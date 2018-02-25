package com.gpcoder.sync;

/**
 * Java class to demonstrate use of synchronization method and block in Java
 * 
 * If you make any static method as synchronized, the lock will be on the class
 * not on object.
 * 
 * Points to remember for Synchronized block: Synchronized block is used to lock
 * an object for any shared resource. Scope of synchronized block is smaller
 * than the method.
 * 
 */
public class SynchronizationExample {
	private static SynchronizationExample instance;

	// Synchronized Method: None-staic method
	public synchronized void lockedByThis() {
		System.out.println(" This synchronized method is locked by current, instance of object, i.e. this");
	}

	// Synchronized Method: Static method
	public static synchronized SynchronizationExample lockedByClassLock() {
		System.out.println("This static synchronized method is locked by class level lock of this class,  "
				+ "i.e. SychronizationExample.class");
		if (instance == null) {
			instance = new SynchronizationExample();
		}

		return instance;
	}

	// Synchronized block
	public static synchronized SynchronizationExample lockedBySynchronizedBlock() {
		System.out.println("This line is executed without locking");
		if (instance == null) {
			synchronized (instance) { // synchronized (SynchronizationExample.class)
				// Thread Safe. Might be costly operation in some case
				if (instance == null) {
					instance = new SynchronizationExample();
				}
			}
		}
		return instance;
	}

}
