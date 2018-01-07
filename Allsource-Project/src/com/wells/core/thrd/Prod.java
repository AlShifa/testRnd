package com.wells.core.thrd;

public class Prod implements Runnable {	
	final SharedObjectt obj;
	Prod(SharedObjectt obj)
	{
		this.obj=obj;
	}

	@Override
	public void run() {
		
		
			int i=100;
			while(true)
			{
				//if(SharedObjectt.x.size()==0 )
				obj.setValue(i);
				i++;			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		// TODO Auto-generated method stub

	}

}
