/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.State;
import jp.topse.patterns.StateContext;

/**
 * @author usamimasanori
 *
 */
public class StateDrivingMode extends State {
	private static StateDrivingMode instance_  = new StateDrivingMode();
	
	private StateDrivingMode() {
	}

	public static StateDrivingMode getInstance() {
		return instance_;
	}
	
	public void action(StateContext context) {
		context.setState(StateSafetyMode.getInstance());
	}
}
