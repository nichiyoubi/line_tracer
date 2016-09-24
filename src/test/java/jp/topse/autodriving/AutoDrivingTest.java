/**
 * 
 */
package jp.topse.autodriving;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author usamimasanori
 *
 */
public class AutoDrivingTest {
	private AutoDriving taxi_ = AutoDriving.getInstance();

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
	 * Test method for {@link jp.topse.autodriving.AutoDriving#getGoal()}.
	 */
	@Test
	public void testGetGoal() {
		assertNull(taxi_.getGoal());
		taxi_.setGoal(CoursePosition.POSITION_A);
		assertEquals(CoursePosition.POSITION_A, taxi_.getGoal());
	}

	/**
	 * Test method for {@link jp.topse.autodriving.AutoDriving#drive()}.
	 */
	@Test
	public void testDrive() {
		fail("Not yet implemented"); // TODO
	}

}
