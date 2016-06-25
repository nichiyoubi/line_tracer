/**
 * 
 */
package jp.topse.line_tracer;

import jp.topse.line_tracer.Wheel;

/**
 * @author usamimasanori
 *
 */
public class DirectionControllerImpl extends DirectionController {
	Wheel rightWheel_;
	Wheel leftWheel_;
	int direction_;
	int max_speed_;

	/**
	 * コンストラクタ
	 * @param right
	 * @param left
	 */
	public DirectionControllerImpl(Wheel right, Wheel left) {
		rightWheel_ = right;
		leftWheel_ = left;
		direction_ = 0;
		max_speed_ = rightWheel_.getMaximumSpeed();
	}

	/* (non-Javadoc)
	 * @see jp.topse.line_tracer.DirectionController#setWheel(jp.topse.line_tracer.Wheel, jp.topse.line_tracer.Wheel)
	 */
	@Override
	void setWheel(Wheel right, Wheel left) {
		rightWheel_ = right;
		leftWheel_ = left;
	}

	/* (non-Javadoc)
	 * 進行方向を設定する
	 * @param direction -100~+100で設定する（-100：左、+100：右）
	 * @see jp.topse.line_tracer.DirectionController#setDirection(int)
	 */
	@Override
	void setDirection(int direction) {
		if ((direction < -100) | (direction > 100)) {
			return;
		}
		direction_ = direction;
		if (direction > 0) {
			leftWheel_.setSpeed(max_speed_ / 2);
//			rightWheel_.setSpeed(max_speed_ - direction);
			rightWheel_.setSpeed(0);
		}
		else if (direction < 0) {
//			leftWheel_.setSpeed(max_speed_ - direction);
			leftWheel_.setSpeed(0);
			rightWheel_.setSpeed(max_speed_ / 2);
		}
		else {
			leftWheel_.setSpeed(max_speed_ / 2);
			rightWheel_.setSpeed(max_speed_ / 2);
		}
		rightWheel_.forward();
		leftWheel_.forward();
	}

	/* (non-Javadoc)
	 * 現在の方向を返す
	 * @see jp.topse.line_tracer.DirectionController#getDirection()
	 */
	@Override
	int getDirection() {
		return direction_;
	}

	/* (non-Javadoc)
	 * 車輪を停止する
	 * @see jp.topse.line_tracer.DirectionController#stop()
	 */
	@Override
	void stop() {
		rightWheel_.stop();
		leftWheel_.stop();
	}

}
