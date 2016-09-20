/**
 * 
 */
package jp.topse.patterns;

/**
 * @author usamimasanori
 *
 */
public abstract class State {
	public void action(StateContext context) {
		context.setState(this);
	}
}
