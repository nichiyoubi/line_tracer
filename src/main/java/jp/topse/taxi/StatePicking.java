/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.StateContext;

/**
 * @author usamimasanori
 *
 */
public class StatePicking extends StateDriving {
	private static StatePicking instance_  = new StatePicking();
	
	private StatePicking() {
	}

	public static StatePicking getInstance() {
		return instance_;
	}

	public void action(StateContext context) {
		context.setState(StateGettingOn.getInstance());
	}
}
