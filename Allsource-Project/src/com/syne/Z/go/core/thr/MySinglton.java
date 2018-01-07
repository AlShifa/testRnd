package com.syne.Z.go.core.thr;

//but eager initialization
class MySingelton
{
	 private static final  MySingelton singelton = new MySingelton();
	 private MySingelton(){}
	
	public  MySingelton getInstacneofMySingelton(){		
		return singelton;			
	}
	public static void main(String[] args) {
		Runtime runtime  = Runtime.getRuntime();
		int x = runtime.availableProcessors();
		System.out.println(x);
		
	}
}


class MySingelton2
{
	private MySingelton2(){}
	private static final MySingelton2 instance2;
	static{		
		instance2 = new MySingelton2();		
	}
	public static MySingelton2 getInstance()
	{
		return instance2;
	}	
}

class MySinglton3
{
 private MySinglton3(){}
 
 private static class MySinglton3Inner{
	 public static final MySinglton3 INSTANCE = new MySinglton3();
 }
 
 public MySinglton3 getInstance()
 {
	 return MySinglton3Inner.INSTANCE;
 }
	
}
class MySinglton4
{
	private static volatile MySinglton4 instance = null;
	private MySinglton4(){}
	public static MySinglton4 getMySinglton4()
	{
		if(instance==null)
		{
			synchronized(MySinglton4.class)
			{
				if(instance == null)
				{
					instance = new MySinglton4();
				}
			}
		}
		return instance;
	}
	
	
}
