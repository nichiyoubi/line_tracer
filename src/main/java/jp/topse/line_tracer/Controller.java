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
public abstract class Controller {
	/**
	 * 
	 * @param light
	 */
	abstract void setLightSensor(LightSensor light);
	
	/**
	 * 
	 * @param direction
	 */
	abstract void setDirectionController(DirectionController direction);
	
	/**
	 * 
	 * @return
	 */
	abstract boolean execute();
}
