/**
 * 
 */
package jp.topse.autodriving;

import jp.topse.autodriving.DirectionController;
import jp.topse.device.LightSensor;

/**
 * @author usamimasanori
 *
 */
public class ControllerOnOff extends Controller {
	private LightSensor light_;
	private DirectionController direction_;

	/**
	 * 
	 * @param light	光センサーオブジェクト
	 * @param direction	方向制御オブジェクト
	 */
	public ControllerOnOff(LightSensor light, DirectionController direction) {
		light_ = light;
		direction_ = direction;
	}

	/* (non-Javadoc)
	 * @see jp.topse.line_tracer.Controller#setLightSensor(jp.topse.line_tracer.LightSensor)
	 */
	@Override
	public void setLightSensor(LightSensor light) {
		light_ = light;
	}

	/* (non-Javadoc)
	 * @see jp.topse.line_tracer.Controller#setDirectionController(jp.topse.line_tracer.DirectionController)
	 */
	@Override
	public void setDirectionController(DirectionController direction) {
		direction_ = direction;
	}

	/* (non-Javadoc)
	 * @see jp.topse.line_tracer.Controller#execute()
	 */
	@Override
	public void execute() {
		float value = light_.getValue();
		if (light_.getThreashold() > value) {
			direction_.setDirection(+100);
		}
		else if (light_.getThreashold() < value) {
			direction_.setDirection(-100);
		}
		else {
			direction_.setDirection(0);
		}
	}
	
	@Override
	public void stop() {
		direction_.stop();
	}

}
