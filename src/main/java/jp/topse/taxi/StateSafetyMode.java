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
public class StateSafetyMode extends State {
	private static StateSafetyMode instance_  = new StateSafetyMode();
	
	private StateSafetyMode() {
	}

	public static StateSafetyMode getInstance() {
		return instance_;
	}
	
	public void action(StateContext context) {
		context.setState(StateDrivingMode.getInstance());
	}
}