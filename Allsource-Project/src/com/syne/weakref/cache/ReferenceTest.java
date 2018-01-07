package com.syne.weakref.cache;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;  
import java.util.HashMap;  
import java.util.Map;  

import com.syne.weakref.AforGC;
  
public class ReferenceTest {  
  
 private WeakReference<Map<Integer, String>> myMap;  
  
 public static void main(String[] args) throws InterruptedException {  
  new ReferenceTest().doFunction();  
 }  
  
 private void doFunction() throws InterruptedException {  
	 
  ReferenceQueue<Map<Integer, String>> queue = new ReferenceQueue<Map<Integer, String>>();
  Map<Integer, String> map = new HashMap<Integer, String>();  
  myMap = new WeakReference<Map<Integer, String>>(map,queue);
  //new WeakRef
    
  map = null;  
  int i = 0;  
  while (true) {  
   if (myMap != null && myMap.get() != null) {  
    myMap.get().put(i++, "test" + i);  
    //Thread.sleep(200);
    System.out.println("im still working!!!!");  
   } else {    
    System.out.println("*******im free*******");  
  
   }  
  
  }  
 }  
}  