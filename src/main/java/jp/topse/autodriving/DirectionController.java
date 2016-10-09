/**
 * 
 */
package jp.topse.line_tracer;

import jp.topse.line_tracer.Wheel;

/**
 * @author usamimasanori
 *
 */
public abstract class DirectionController {
	/**
	 * 操作対象の車輪を設定する
	 * @param right 右の車輪
	 * @param left 左の写真
	 */
	abstract void setWheel(Wheel right, Wheel left);
	
	/**
	 * 進行方向を設定する
	 * @param direction 進行方向（-100：左~100：右）
	 */
	abstract void setDirection(int direction);
	
	/**
	 * 現在の進行方向を戻り値として返す
	 * @return 現在の進行方向（-100：左〜100：右）
	 */
	abstract int getDirection();
	
	/**
	 * 
	 */
	abstract void stop();
}
