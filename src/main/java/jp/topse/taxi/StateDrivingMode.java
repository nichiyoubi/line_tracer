/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.State;
import jp.topse.patterns.StateContext;
import jp.topse.autodriving.AutoDriving;

/**
 * @author usamimasanori
 *
 */
public class StateDrivingMode extends State {
	private static StateDrivingMode instance_  = new StateDrivingMode();
	private AutoDriving driver_;
	
	private StateDrivingMode() {
	}

	public static StateDrivingMode getInstance() {
		return instance_;
	}
	
	public void action(StateContext context) {
		context.setState(StateSafetyMode.getInstance());
	}
	
	public void setAutoDriving(AutoDriving driver) {
		driver_ = driver;
	}
	
	public AutoDriving getAutoDriving() {
		return driver_;
	}
}
