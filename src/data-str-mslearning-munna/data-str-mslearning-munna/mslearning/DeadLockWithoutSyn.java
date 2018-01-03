package mslearning;

public class DeadLockWithoutSyn {
	
	private static int initialized ;
	
	static{
		
		Thread t = new Thread(){
			
			public void  run()
			{
				System.out.println(initialized);
			}
		};
		t.start();		
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(initialized);
	}
}
