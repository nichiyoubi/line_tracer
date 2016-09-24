/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.State;
import jp.topse.line_tracer.*;

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
