/**
 * 
 */
package jp.topse.taxi;

/**
 * @author usamimasanori
 *
 */
public class StateDrivingMock extends StateDriving {
	static private StateDrivingMock instance_ = new StateDrivingMock();
	
	private StateDrivingMock() {
	}

	static StateDrivingMock getInstance() {
		return instance_;
	}
}
