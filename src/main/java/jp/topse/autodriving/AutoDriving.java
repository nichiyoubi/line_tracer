/**
 * 
 */
package jp.topse.autodriving;

/**
 * @author usamimasanori
 *
 */
public class AutoDriving {
	static private AutoDriving instance_ = new AutoDriving();
	private CoursePosition pos_ = null;
	
	private AutoDriving() {
		
	}
	
	public static AutoDriving getInstance() {
		return instance_;
	}
	
	public void setGoal(CoursePosition pos) {
		pos_ = pos;
	}
	
	public CoursePosition getGoal() {
		return pos_;
	}
	
	public void drive() {
		
	}
}
