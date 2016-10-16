/**
 * 
 */
package jp.topse.taxi;

import jp.topse.autodriving.Controller;
import jp.topse.patterns.State;
import jp.topse.patterns.StateContext;
import jp.topse.taxi.StateDrivingMode;

/**
 * @author usamimasanori
 *
 */
public abstract class StateDriving extends State {
	private static Controller controller_ = null;
	protected static ContextDriving context_ = ContextDriving.getInstance();
		
	public void setController(Controller cont) {
		controller_ = cont;
	}
	
	public Controller getController() {
		return controller_;
	}
		
	public void action(StateContext context) {
		context_.action();
		super.action(context);
	}
}
