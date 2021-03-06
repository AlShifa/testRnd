package com.syne.weakref;

/* Final references, used to implement finalization */

class FinalReference<T> extends Reference<T> {

    public FinalReference(T referent, ReferenceQueue<? super T> q) {
	super(referent, q);
    }

}
