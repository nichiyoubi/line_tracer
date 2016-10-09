/**
 * 
 */
package jp.topse.patterns;

// import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.topse.taxi.StateDrivingMode;
import jp.topse.taxi.StateGettingOff;
import jp.topse.taxi.StateGettingOn;
import jp.topse.taxi.StatePicking;
import jp.topse.taxi.StateReturning;
import jp.topse.taxi.StateSafetyMode;
import jp.topse.taxi.StateTaking;
import jp.topse.taxi.StateWaiting;

/**
 * @author usamimasanori
 *
 */
public class StateTest {
	StateContext context_ = null;
	State state_ = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		State state = new ConcreteStateA();
		context_ = new ConcreteContext();
		context_.setState(state);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link jp.topse.patterns.State#action(jp.topse.patterns.StateContext)}.
	 */
	@Test
	public void testAction() {
		State state = context_.getState();
		assert(state instanceof ConcreteStateA);
		context_.action();
		state = context_.getState();
		assert(state instanceof ConcreteStateB);
		context_.action();
		state = context_.getState();
		assert(state instanceof ConcreteStateA);		
	}

	@Test
	public void testAction2() {
		context_.setState(StateWaiting.getInstance());
		assert(context_.getState() instanceof StateWaiting);
		
		context_.action();
		assert(context_.getState() instanceof StatePicking);		
		
		context_.action();
		assert(context_.getState() instanceof StateGettingOn);		
		
		context_.action();
		assert(context_.getState() instanceof StateTaking);		
		
		context_.action();
		assert(context_.getState() instanceof StateGettingOff);		
		
		context_.action();
		assert(context_.getState() instanceof StateReturning);		
		
		context_.action();
		assert(context_.getState() instanceof StateWaiting);	
	}
	
	@Test
	public void testAction3() {
		context_.setState(StateDrivingMode.getInstance());
		assert(context_.getState() instanceof StateDrivingMode);
		
		context_.action();
		assert(context_.getState() instanceof StateSafetyMode);		
		
		context_.action();
		assert(context_.getState() instanceof StateDrivingMode);		
		
	}
}
