/**
 * 
 */
package jp.topse.device;

/**
 * 光センサー
 * @author usamimasanori
 *
 */
public interface LightSensor {
	/** 
	 * 光センサーの値の取得
	 * @return float型の値 EV3ColorSensorの生値
	 */
	float getValue();
	
	/**
	 * トレースする経路濃霧を識別するための閾値を設定する
	 * @param threashold 閾値
	 */
	void setThreashold(float threashold);

	/**
	 * トレースする経路（ライン）の有無を検出する閾値を取得する
	 * 閾値は光センサー自身が自動検出できないためsetThreashold()で設定する
	 * @return	コースの有無を判定する閾値の設定値（setThreasholdで設定した値）を返す
	 */
	float getThreashold();
}
