package com.syne.thr;

public class HelloVolatile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Count cnt = new Count();
		
		(new Thread("fst"){ public void run(){ 
			int i=1 ;while(i<100){				
				cnt.setCount();
				i++;
		} } }).start();
		
		(new Thread("scnd"){ public void run(){ 
			int i=1 ;while(i<100){				
				cnt.setCount();	
				i++;
		} } }).start();
		
	}
	
}

