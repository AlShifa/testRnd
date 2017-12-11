import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProdConsTestMain {

    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();

        ProducerThrd prod = new ProducerThrd(sharedObject);
        Thread prd = new Thread(prod);
        System.out.println(prd.getState());
        prd.start();
        System.out.println(prd.getState());


        ConsumerThrd cons = new ConsumerThrd(sharedObject);
        Thread consuThr = new Thread(cons);
        System.out.println(consuThr.getState());
        consuThr.start();
        System.out.println(consuThr.getState());

        //ExecutorService executor = Executors..newFixedThreadPool(5);


    }
}
