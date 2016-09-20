/**
 * 
 */
package jp.topse.patterns;

/**
 * @author usamimasanori
 *
 */
public abstract class StateContext {
	private State state_ = null;
	
	public StateContext() {
	}
	
	public State getState() {
		return state_;
	}
	
	public void setState(State state) {
		state_  = state;
	}
	
	public void action() {
		state_.action(this);
	}
}
