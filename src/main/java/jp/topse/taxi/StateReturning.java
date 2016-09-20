/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.StateContext;

/**
 * @author usamimasanori
 *
 */
public class StateReturning extends StateDriving {
	private static StateReturning instance_  = new StateReturning();
	
	private StateReturning() {
	}

	public static StateReturning getInstance() {
		return instance_;
	}

	public void action(StateContext context) {
		context.setState(StateWaiting.getInstance());
	}

}
