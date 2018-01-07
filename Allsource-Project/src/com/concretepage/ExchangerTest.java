    package com.concretepage;
     
    import java.util.ArrayList;
    import java.util.List;
    import java.util.concurrent.Exchanger;
     
    public class ExchangerTest {
     
    Exchanger<List<String>> exchanger = new Exchanger<List<String>>();
    List<String> exchnagerList= new ArrayList<String>();
    
    class AddList implements Runnable {
	    public void run() {
	    try {
	    while (true) {
	    
	    	exchnagerList.add("1");    
	    	if (exchnagerList.size()==1){
	    		System.out.println("***Add Exchange***");
	    		exchnagerList = exchanger.exchange(exchnagerList);
	    	}
	    
	    }
	    } 
	    catch (InterruptedException ex) { System.out.println(ex); }
	    } // run
    }
    class SubtractList implements Runnable {
    public void run() {
    try {
    while (true) {
    exchnagerList.remove("1");
    if (exchnagerList.size()==0){
    	
    	System.out.println("***Sub Exchange***");
    	exchnagerList = exchanger.exchange(exchnagerList);
    	
    }
    }
    } catch (InterruptedException ex) { System.out.println(ex);}
    }
    }
    public static void main(String... args) {
    new Thread((new ExchangerTest()).new SubtractList()).start();
    new Thread((new ExchangerTest()).new AddList()).start();
    }
    }

