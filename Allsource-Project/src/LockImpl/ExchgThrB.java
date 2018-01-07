package LockImpl;

import java.util.concurrent.Exchanger;

public class ExchgThrB implements Runnable {
	
	String thrB;
	ExchgThrB(String name, String thrB,Exchanger<Object> ex)
	{
		Thread t = new Thread(this);
		t.start();
		t.setName(name);
		//.
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
