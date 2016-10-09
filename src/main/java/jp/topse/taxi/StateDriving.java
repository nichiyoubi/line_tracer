/**
 * 
 */
package jp.topse.taxi;

import jp.topse.autodriving.Controller;
import jp.topse.patterns.State;

/**
 * @author usamimasanori
 *
 */
public abstract class StateDriving extends State {
	private static Controller controller_ = null;
		
	public void setController(Controller cont) {
		controller_ = cont;
	}
	
	public Controller getController() {
		return controller_;
	}
}
