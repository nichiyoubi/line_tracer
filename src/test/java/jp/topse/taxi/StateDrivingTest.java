/**
 * 
 */
package jp.topse.taxi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import jp.topse.line_tracer.*;

/**
 * @author usamimasanori
 *
 */
public class StateDrivingTest {
	private StateDriving taxi_ = StateDrivingMock.getInstance();

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
	 * Test method for {@link jp.topse.taxi.StateDriving#setController(jp.topse.line_tracer.Controller)}.
	 */
	@Test
	public void testSetController() {
		assertNull(taxi_.getController());
		taxi_.setController(new MockController());
		assertNotNull("Controllerのsetが失敗", taxi_.getController());
	}
}
