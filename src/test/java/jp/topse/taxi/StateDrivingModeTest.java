/**
 * 
 */
package jp.topse.taxi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.topse.autodriving.AutoDriving;

/**
 * @author usamimasanori
 *
 */
public class StateDrivingModeTest {
	private static StateDrivingMode mode_ = StateDrivingMode.getInstance();

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
	 * Test method for {@link jp.topse.taxi.StateDrivingMode#action(jp.topse.patterns.StateContext)}.
	 */
	@Test
	public void testAction() {
		ContextDriving context = ContextDriving.getInstance();
		context.setState(mode_);
		context.action();
		assertEquals(context.getState(), StateSafetyMode.getInstance());
	}

	/**
	 * Test method for {@link jp.topse.taxi.StateDrivingMode#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		assertEquals(mode_, StateDrivingMode.getInstance());
	}

	/**
	 * Test method for {@link jp.topse.taxi.StateDrivingMode#setAutoDriving(jp.topse.autodriving.AutoDriving)}.
	 */
	@Test
	public void testSetAutoDriving() {
		mode_.setAutoDriving(AutoDriving.getInstance());
		assertEquals(mode_.getAutoDriving(), AutoDriving.getInstance());
	}

	/**
	 * Test method for {@link jp.topse.taxi.StateDrivingMode#getAutoDriving()}.
	 */
	@Test
	public void testGetAutoDriving() {
		assertNull(mode_.getAutoDriving());
		mode_.setAutoDriving(AutoDriving.getInstance());
		assertEquals(mode_.getAutoDriving(), AutoDriving.getInstance());
	}

}
