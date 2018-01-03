package com.syne.thr;

public class CallTwoThread {

	public static void main(String arg[]) throws Exception {
		final ReadWriteValue rdWrValue = new ReadWriteValue();

		(new Thread("set") {
			public void run() {
				int value = 1;
				while (true) {
					rdWrValue.setValue(value);
					value++;

				}

			}
		}).start();

		/*(new Thread("get") {
			public void run() {
				int value = 1;
				while (true) {

					int getresult = rdWrValue.getValue();
					value++;

				}
			}
		}).start();*/
		(new Thread("call") {
			public void run() {
				int value = 1;
				while (true) {
					rdWrValue.callThr(value);
					value++;

				}
			}
		}).start();
	}

}
