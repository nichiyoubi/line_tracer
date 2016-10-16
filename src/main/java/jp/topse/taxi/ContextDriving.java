/**
 * 
 */
package jp.topse.taxi;

import jp.topse.patterns.StateContext;

/**
 * @author usamimasanori
 *
 */
public class ContextDriving extends StateContext {
	private static ContextDriving instane_ = new ContextDriving();
	
	private ContextDriving() {
		
	}
	
	public static ContextDriving getInstance() {
		return instane_;
	}
}
