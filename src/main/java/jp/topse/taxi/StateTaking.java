/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.StateContext;
import jp.topse.autodriving.AutoDriving;

/**
 * @author usamimasanori
 *
 */
public class StateTaking extends StateDriving {
	private static StateTaking instance_  = new StateTaking();
	
	private StateTaking() {
	}

	public static StateTaking getInstance() {
		return instance_;
	}

	public void action(StateContext context) {
		context.setState(StateGettingOff.getInstance());
	}
}
