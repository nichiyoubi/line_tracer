/**
 * 
 */
package jp.topse.autodriving;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
//import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.HttpURLConnection;
import org.json.simple.*;

import jp.topse.device.LightSensor;
import jp.topse.device.Wheel;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

/**
 * @author usamimasanori
 *
 */
public class RemoteDataProvider implements Runnable {
	private Socket connSocket_ = null;
	private LightSensor light_ = null;
	private Wheel rightWheel_ = null;
	private Wheel leftWheel_ = null;
	private URL url_ = null;
	private HttpURLConnection connection_ = null;
	
	/*
	 * 
	 * @param light
	 * @param right
	 * @param left
	 */
	public RemoteDataProvider(LightSensor light, Wheel right, Wheel left) {
		light_ = light;
		rightWheel_ = right;
		leftWheel_ = left;
	}
	
	/*
	 * 
	 * @return
	 */
	private boolean connect() {
		try {
//			url_ = new URL("http://192.168.11.3:8080/");
			url_ = new URL("http://model-check.appspot.com/");
			try {
				connection_ = (HttpURLConnection) url_.openConnection();
				connection_.setDoOutput(true);
				connection_.setRequestMethod("POST");
				return true;
			}
			catch (IOException e) {
				if (connection_ != null) {
					connection_.disconnect();
				}
				return false;
			}
		}
		catch (IOException e) {
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int cnt = 0;
		while(!connect()) {
			Delay.msDelay(1000);
			LCD.drawString("CONN:" + (cnt++), 0, 5);
		}
		LCD.drawString("RDATA ", 0, 5);
		
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection_.getOutputStream(), StandardCharsets.UTF_8));
			while(true) {
				float light = light_.getValue();
				int right = rightWheel_.getSpeed();
				int left = leftWheel_.getSpeed();
				JSONObject json = new JSONObject();
				
				/// データを整形する
				json.put("light", String.valueOf(light));
				json.put("motor(rigth)", String.valueOf(right));
				json.put("motor(left)", String.valueOf(left));
				///　データを送信する
				writer.write(json.toJSONString());
				writer.flush();
				if (connection_.getResponseCode() != HttpURLConnection.HTTP_OK) {
					LCD.drawString("ERROR2", 0, 5);
					break;
				}
				Delay.msDelay(1000);
				LCD.drawString("RDATA " + (cnt++), 0, 5);
			}
		}
		catch(IOException e1) {
			LCD.drawString("ERROR1", 0, 5);
			try {
				if (connSocket_ != null) {
					connSocket_.close();
				}
			}
			catch(IOException e2) {
			}
		}
	}
}
