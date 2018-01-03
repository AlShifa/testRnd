package com.syne.Z.go.core.Refe;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
 

public class ClassWeak {
 
    public static class Referred {
        protected void finalize() {
            System.out.println("Good bye cruel world");
        }
    }
 
    public static void collect() throws InterruptedException {
        System.out.println("Suggesting collection");
        System.gc();
        System.out.println("Sleeping");
        Thread.sleep(5000);
    }
 
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Creating weak references");
 
        // This is now a weak reference.
        // The object will be collected only if no strong references.
        Referred strong = new Referred();
       // WeakReference<Referred> weak = new WeakReference<Referred>(strong);
 
        // Attempt to claim a suggested reference.
        ClassWeak.collect();
 
        System.out.println("Removing reference");
        // The object may be collected.
        strong = null;
        ClassWeak.collect();
 
        System.out.println("Done");
    }
 
}