package com.syne.Z.go.core.thr;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {

	private Timer timer = null;

	public TimerExample(int seconds) {
		System.out.println("In timer");
		timer = new Timer();
		timer.schedule(new MyTask("T 1"), seconds * 1000, 3000);
	}

	class MyTask extends TimerTask {

		private String name;
		public MyTask(String name) {
			this.name = name;
		}
		@Override
		public void run() {
			System.out.println("In My Task : " + this.name);
		}
	}

	public static void main(String[] args) {
		
		TimerExample t = new TimerExample(3);
		TimerExample t1 = new TimerExample(5);
		System.out.println("Task Scheduled");

	}

}
