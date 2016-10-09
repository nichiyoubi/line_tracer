/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.StateContext;
import jp.topse.autodriving.Controller;
import jp.topse.autodriving.ControllerOnOff;
import jp.topse.autodriving.DirectionControllerImpl;
import jp.topse.device.LightSensorImpl;
import jp.topse.device.WheelImpl;
import lejos.hardware.port.*;
import lejos.utility.Delay;
import lejos.hardware.BrickFinder;
import lejos.hardware.Key;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;

/**
 * @author usamimasanori
 *
 */
public class Taxi extends StateContext {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LightSensorImpl light = new LightSensorImpl(SensorPort.S2);
		light.setThreashold(0.15F);
		// TODO: 超音波センサーの初期化
		// TODO: 液晶の初期化
		Key enter = ((EV3)BrickFinder.getLocal()).getKey("Enter");
		ControllerOnOff controller = new ControllerOnOff(light,
										new DirectionControllerImpl(
												new WheelImpl(MotorPort.B), 
												new WheelImpl(MotorPort.C)));
		StateContext context = new ContextTaxi();
		context.setState(StateWaiting.getInstance());
		
		initialize(enter);
	
		try {
			while(true) {
				Delay.msDelay(100);
				context.action();
				LCD.drawString("light=" + String.valueOf(light.getValue()), 0, 3);
				if (enter.isDown()) {
					shutdown(controller);
				}
			}
		}
		finally {
			shutdown(controller);
		}
	}
	
	/**
	 * ロボットの初期化を行う
	 */
	private static void initialize(Key enter) {
		LCD.clear();
		LCD.drawString("Push Start.", 0, 2);
		while(enter.isUp()) {
			Delay.msDelay(100);
		}
		LCD.clear();
	}
	
	/**
	 * ロボットの終了
	 */
	private static void shutdown(Controller controller) {
		controller.stop();
		System.exit(0);
	}
}
