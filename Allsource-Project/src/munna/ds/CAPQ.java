package munna.ds;

public class CAPQ<E> {
	
	Object[] pqueue;
	int rear;
	int front;
	
	CAPQ()
	{
		pqueue = new Object[10];
		
	}
	void add(E v) {
		// ensurecapacity();
		if (rear == front) {
			rear = front = 0;
			pqueue[rear] = v;
		} else {
			pqueue[rear] = v;
			rear++;
		}
	}

	E peak() {
		E v = (E) pqueue[front];
		front--;
		return v;
	}

	E poll() {
		E v = (E) pqueue[front];
		front--;
		pqueue[front] = null;
		return v;
	}
	
	

}
