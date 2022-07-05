/**
 * 
 */
package com.gtm.volatileEx;

/**
 * @author kumarga
 *
 */
public class SingletoneWithVolatile{

	private static volatile SingletoneWithVolatile singletoneWithVolatile;
	private volatile int count = 1;

	private SingletoneWithVolatile(){}

	public static SingletoneWithVolatile getInstance() {
		if (singletoneWithVolatile == null) {
			synchronized (SingletoneWithVolatile.class) {
				if (singletoneWithVolatile == null) {
					singletoneWithVolatile = new SingletoneWithVolatile();
				}
			}
		}
		return singletoneWithVolatile;
	}
	public synchronized void dispInstance() {
		System.out.println("SingletoneWithVolatile : "+count+"->"+singletoneWithVolatile);
		++count;
	}


}
