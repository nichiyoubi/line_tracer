/**
 * 
 */
package jp.topse.line_tracer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author usamimasanori
 *
 */
public class RemoteDataProviderTest {
	RemoteDataProvider provider_;
	MockLightSensor light_;
	MockWheel r_motor_;
	MockWheel l_motor_;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		light_ = new MockLightSensor();
		r_motor_ = new MockWheel();
		l_motor_ = new MockWheel();
		provider_ = new RemoteDataProvider(light_, r_motor_, l_motor_);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		provider_  = null;
		light_ = null;
		r_motor_ = null;
		l_motor_  = null;
	}

	/**
	 * Test method for {@link jp.topse.line_tracer.RemoteDataProvider#json2str()}.
	 */
	@Test
	public void testJson2str() {
		System.out.println(provider_.json2str());
		fail("Not yet implemented");
	}

}
