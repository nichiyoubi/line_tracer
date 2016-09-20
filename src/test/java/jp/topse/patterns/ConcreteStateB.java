/**
 * 
 */
package jp.topse.patterns;

/**
 * @author usamimasanori
 *
 */
public class ConcreteStateB extends State {
	public void action(StateContext context) {
		System.out.println("ConcreteStateB::action()");
		context.setState(new ConcreteStateA());
	}
}
