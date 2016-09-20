/**
 * 
 */
package jp.topse.patterns;

/**
 * @author usamimasanori
 *
 */
public class ConcreteStateA extends State {
	public void action(StateContext context) {
		System.out.println("ConcreteStateA::action()");
		context.setState(new ConcreteStateB());
	}
}
