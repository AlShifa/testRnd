package munna.thr;

import java.util.concurrent.Semaphore;

class Pool {
	
	private static final int MAX_AVAILABLE = 3;
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
	
	   // Not a particularly efficient data structure; just for demo
	   protected Object[] items = new String[]{"a","b","c"}; //.. whatever kinds of items being managed
	   protected boolean[] used = new boolean[MAX_AVAILABLE];
	   
	   
	   public Object getItem() throws InterruptedException {
	     available.acquire();
	     return getNextAvailableItem();
	   }

	   public void putItem(Object x) {
	     if (markAsUnused(x))
	       available.release();
	   }	

	   protected synchronized Object getNextAvailableItem() {
	     for (int i = 0; i < MAX_AVAILABLE; ++i) {
	       if (!used[i]) {
	          used[i] = true;
	          return items[i];
	       }
	     }
	     return null; // not reached
	   }
	   protected synchronized boolean markAsUnused(Object item) {
		     for (int i = 0; i < MAX_AVAILABLE; ++i) {
		         if (item == items[i]) {
		            if (used[i]) {
		              used[i] = false;
		              return true;
		            } else
		              return false;
		         }
		       }
		       return false;
		     }
	}

