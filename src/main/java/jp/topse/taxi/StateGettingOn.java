/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.StateContext;

/**
 * @author usamimasanori
 *
 */
public class StateGettingOn extends StateStopping {
	private static StateGettingOn instance_  = new StateGettingOn();
	
	private StateGettingOn() {
	}

	public static StateGettingOn getInstance() {
		return instance_;
	}

	public void action(StateContext context) {
		context.setState(StateTaking.getInstance());
	}

}
