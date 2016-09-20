/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.StateContext;

/**
 * @author usamimasanori
 *
 */
public class StateWaiting extends StateStopping {
	private static StateWaiting instance_  = new StateWaiting();
	
	private StateWaiting() {
	}

	public static StateWaiting getInstance() {
		return instance_;
	}
	
	public void action(StateContext context) {
		context.setState(StatePicking.getInstance());
	}
}
