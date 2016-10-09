/**
 * 
 */
package jp.topse.device;

import jp.topse.autodriving.Controller;
import jp.topse.autodriving.ControllerOnOff;
import jp.topse.autodriving.DirectionController;
import jp.topse.autodriving.DirectionControllerImpl;
import jp.topse.autodriving.RemoteController;
import jp.topse.autodriving.RemoteDataProvider;
import jp.topse.device.LightSensorImpl;
import jp.topse.device.WheelImpl;
import lejos.hardware.BrickFinder;
import lejos.hardware.Key;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * @author usamimasanori
 *
 */
public class LineTracer {

	/**
	 * @param args	引数（本プログラムでは使用しない）
	 */
	public static void main(String[] args) {
		LightSensorImpl light =  new LightSensorImpl(SensorPort.S2);
		WheelImpl rightWheel = new WheelImpl(MotorPort.B);
		WheelImpl leftWheel = new WheelImpl(MotorPort.C);
		DirectionControllerImpl direction = new DirectionControllerImpl(rightWheel, leftWheel);
		ControllerOnOff controller = new ControllerOnOff(light, direction);

		Key enter   = ((EV3)BrickFinder.getLocal()).getKey("Enter");
		LCD.drawString("Push Start.", 0, 2);
		while(enter.isUp()) {
			Delay.msDelay(100);
		}
		LCD.drawString("           ", 0, 2);

		/// ネットワーク・リモート制御スレッドの起動
		RemoteController remoteController = new RemoteController(direction);
		Thread threadController = new Thread(remoteController);
		threadController.start();
		
		///　ネットワーク・データ送信スレッドの起動
		RemoteDataProvider dataProvider = new RemoteDataProvider(light, rightWheel, leftWheel);
		Thread threadProvider = new Thread(dataProvider);
		threadProvider.start();

		/// ライントレーサの起動
		trace(light, controller, direction, enter);
	}
	
	public static void trace(LightSensor light, Controller controller, 
			DirectionController direction, Key enter) {		
		light.setThreashold(0.15F);
		
		for(int i = 0; i < 1200; i++) {
			Delay.msDelay(100);
			controller.execute();
			Float val = light.getValue();
			LCD.drawString("light=" + String.valueOf(val), 0, 3);
			if (enter.isDown()) {
				direction.stop();
				System.exit(0);
			}
		}
	}
}
