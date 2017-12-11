import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SharedObject {

    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 4;

    void setList() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                if (list.size() == capacity) {
                    wait();
                } else {

                    list.add(value);
                    System.out.println("Producer -"
                            + value);
                    value++;
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

    }

    Integer getList() throws InterruptedException {
        //return list.get();
        while (true) {
            synchronized (this) {

                if (list.isEmpty()) {
                    wait();
                } else {
                    int val = list.removeFirst();
                    System.out.println("Consumer consumed-"
                            + val);
                    Thread.sleep(1000);
                    notify();
                }
            }

        }
    }
}
