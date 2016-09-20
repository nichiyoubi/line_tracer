/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.StateContext;

/**
 * @author usamimasanori
 *
 */
public class StateGettingOff extends StateStopping {
	private static StateGettingOff instance_  = new StateGettingOff();
	
	private StateGettingOff() {
	}

	public static StateGettingOff getInstance() {
		return instance_;
	}

	public void action(StateContext context) {
		context.setState(StateReturning.getInstance());
	}
}
