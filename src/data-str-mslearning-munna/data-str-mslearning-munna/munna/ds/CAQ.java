package munna.ds;

import java.util.AbstractQueue;

public class CAQ<E> {

	Object[] queue;
	int rear;
	int front;

	CAQ() {
		queue = new Object[10];
	}

	void add(E v) {
		// ensurecapacity();
		if (rear == front) {
			rear = front = 0;
			queue[rear] = v;
		} else {
			queue[rear] = v;
			rear++;
		}
	}

	E peak() {
		E v = (E) queue[front];
		front--;
		return v;
	}

	E poll() {
		E v = (E) queue[front];
		front--;
		queue[front] = null;
		return v;
	}
	//AbstractQueue<E>

}
