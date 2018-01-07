package LockImpl;

public class ImplMain {

	/**
	 * @param args
	 */
	static SharedResourc sr = new SharedResourc();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mythread t = new Mythread();
		MythreadGET t2 = new MythreadGET();

	}

	static private class Mythread implements Runnable {
		
		Thread t ;
		Mythread()
		{
			t= new Thread(this);
			t.start();
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				try {
					sr.setValue();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
static private class MythreadGET implements Runnable {
		
		Thread t ;
		MythreadGET()
		{
			t= new Thread(this);
			t.start();
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				try {
					sr.getValue();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
