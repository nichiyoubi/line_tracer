/**
 * 
 */
package jp.topse.line_tracer;

import jp.topse.line_tracer.DirectionController;
import jp.topse.line_tracer.LightSensor;

/**
 * @author usamimasanori
 *
 */
public class ControllerOnOff extends Controller {
	private LightSensor light_;
	private DirectionController direction_;

	/**
	 * 
	 * @param light
	 * @param direction
	 */
	public ControllerOnOff(LightSensor light, DirectionController direction) {
		light_ = light;
		direction_ = direction;
	}

	/* (non-Javadoc)
	 * @see jp.topse.line_tracer.Controller#setLightSensor(jp.topse.line_tracer.LightSensor)
	 */
	@Override
	void setLightSensor(LightSensor light) {
		light_ = light;
	}

	/* (non-Javadoc)
	 * @see jp.topse.line_tracer.Controller#setDirectionController(jp.topse.line_tracer.DirectionController)
	 */
	@Override
	void setDirectionController(DirectionController direction) {
		direction_ = direction;
	}

	/* (non-Javadoc)
	 * @see jp.topse.line_tracer.Controller#execute()
	 */
	@Override
	boolean execute() {
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
		return true;
	}

}
