package singleton.multithread;

import org.apache.log4j.Logger;

public class MultiThreadedSingleton {
	private static MultiThreadedSingleton singleton = null;
	private static Logger logger = Logger.getRootLogger();
	private static boolean firstThread = true;

	private MultiThreadedSingleton() {
		// Exists only to defeat instantiation.
	}

	// not adding synchronized will result in the test case to fail.
	// can also be achieved by adding synchronized keyword to the method
	public static synchronized MultiThreadedSingleton getInstance() {
		//Lazy instantiation using double locking mechanism.
		if (singleton == null) {
			synchronized (MultiThreadedSingleton.class) {
				if (singleton == null) {
					simulateRandomActivity();
					singleton = new MultiThreadedSingleton();
				}
			}
		}
		logger.info("created singleton: " + singleton);
		return singleton;
	}

	private static void simulateRandomActivity() {
		try {
			if (firstThread) {
				firstThread = false;
				logger.info("sleeping...");
				// This nap should give the second thread enough time
				// to get by the first thread.
				Thread.currentThread().sleep(50);
			}
		} catch (InterruptedException ex) {
			logger.warn("Sleep interrupted");
		}
	}
}