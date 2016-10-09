/**
 * 
 */
package jp.topse.device;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

/**
 * @author usamimasanori
 *
 */
public class LightSensorImpl extends EV3ColorSensor implements LightSensor {
	float threashold_;
	SampleProvider provider_;
	float[] sample_;

	/**
	 * コンストラクタ
	 * @param port 光センサーが接続されるポート（１〜４）
	 */
	public LightSensorImpl(Port port) {
		super(port);
		threashold_ = 0;
		provider_ = this.getRedMode();
		sample_ = new float[provider_.sampleSize()];
	}
	
	/* (non-Javadoc)
	 * @see jp.topse.line_tracer.LightSensor#getValue()
	 */
	@Override
	public float getValue() {
		provider_.fetchSample(sample_, 0);
		return sample_[0];
	}

	/* (non-Javadoc)
	 * @see jp.topse.line_tracer.LightSensor#setThreashold(float)
	 */
	@Override
	public void setThreashold(float threashold) {
		threashold_ = threashold;
	}

	/* (non-Javadoc)
	 * @see jp.topse.line_tracer.LightSensor#getThreashold()
	 */
	@Override
	public float getThreashold() {
		return threashold_;
	}

}
