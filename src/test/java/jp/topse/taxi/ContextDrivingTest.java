/**
 * 
 */
package jp.topse.taxi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author usamimasanori
 *
 */
public class ContextDrivingTest {
	private ContextDriving driving_ = ContextDriving.getInstance();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link jp.topse.taxi.ContextDriving#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		assertEquals(driving_, ContextDriving.getInstance());
	}

	/**
	 * Test method for {@link jp.topse.patterns.StateContext#getState()}.
	 */
	@Test
	public void testGetState() {
		assertNull(driving_.getState());
	}

	/**
	 * Test method for {@link jp.topse.patterns.StateContext#setState(jp.topse.patterns.State)}.
	 */
	@Test
	public void testSetState() {
		driving_.setState(StateDrivingMode.getInstance());
		assertEquals(driving_.getState(), StateDrivingMode.getInstance());
	}

	/**
	 * Test method for {@link jp.topse.patterns.StateContext#action()}.
	 */
	@Test
	public void testAction() {
		driving_.setState(StateDrivingMode.getInstance());
		driving_.action();
		assertEquals(driving_.getState(), StateSafetyMode.getInstance());
	}

}
