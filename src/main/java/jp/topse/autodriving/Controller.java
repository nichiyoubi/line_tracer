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
public abstract class Controller {
	/**
	 * 
	 * @param light
	 */
	public abstract void setLightSensor(LightSensor light);
	
	/**
	 * 
	 * @param direction
	 */
	public abstract void setDirectionController(DirectionController direction);
	
	/**
	 * 
	 * @return
	 */
	public abstract void execute();
	
	/**
	 * 
	 */
	public abstract void stop();
}
