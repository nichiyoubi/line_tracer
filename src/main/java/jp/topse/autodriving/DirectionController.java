/**
 * 
 */
package jp.topse.autodriving;

import jp.topse.device.Wheel;

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
	public abstract void setWheel(Wheel right, Wheel left);
	
	/**
	 * 進行方向を設定する
	 * @param direction 進行方向（-100：左~100：右）
	 */
	public abstract void setDirection(int direction);
	
	/**
	 * 現在の進行方向を戻り値として返す
	 * @return 現在の進行方向（-100：左〜100：右）
	 */
	public abstract int getDirection();
	
	/**
	 * 
	 */
	public abstract void stop();
}
