package com.syne.thr.executor;

//: BlockingQueueTest.java
public class BlockingQueueTest {
  private final BlockingQueue bq = new BlockingQueue();
  /**
    The Worker thread is not very robust.  If a RuntimeException
    occurse in the run method, the thread will stop.
   */
  private class Worker extends Thread {
    public Worker(String name) { super(name); start(); }
    public void run() {
      try {
        while(!isInterrupted()) {
          ((Runnable)bq.pop()).run();
        }
      } catch(InterruptedException ex) {}
      System.out.println(getName() + " finished");
    }
  }
  public BlockingQueueTest() {
    // We create 10 threads as workers
    Thread[] workers = new Thread[10];
    for (int i=0; i<workers.length; i++)
      workers[i] = new Worker("Worker Thread " + i);
    // We then push 100 commands onto the queue
    for (int i=0; i<100; i++) {
      final String msg = "Task " + i + " completed";
      bq.push(new Runnable() {
        public void run() {
          System.out.println(msg);
          // Sleep a random amount of time, up to 1 second
          try { Thread.sleep((long)(Math.random()*1000)); }
          catch(InterruptedException ex) { }
        }
      });
    }
    // We then push one "poison pill" onto the queue for each
    // worker thread, which will only be processed once the other
    // tasks are completed.
    for (int i=0; i<workers.length; i++) {
      bq.push(new Runnable() {
        public void run() {
          Thread.currentThread().interrupt();
        }
      });
    }
    // Lastly we join ourself to each of the Worker threads, so
    // that we only continue once all the worker threads are
    // finished.
    for (int i=0; i<workers.length; i++) {
      try {
        workers[i].join();
      } catch(InterruptedException ex) {}
    }
    System.out.println("BlockingQueueTest finished");
  }
  public static void main(String[] args) throws Exception{
    new BlockingQueueTest();
  }
}

