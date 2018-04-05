public class RequestHitCounter {

	private int httpRequest;
	private int httpSSLRequest;

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void incrementHTTPRequest() {
		synchronized (lock1) {
			httpRequest++;
		}

	}

	public void incrementHTTPSSLRequest() {
		synchronized (lock2) {
			httpSSLRequest++;
		}
	}

}
