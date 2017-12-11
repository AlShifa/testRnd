public class ProducerThrd implements Runnable {

    SharedObject shaObj = null;
    int value = 1;
    ProducerThrd(SharedObject sharedObject){
        this.shaObj = sharedObject;
    }
    @Override
    public void run() {
        System.out.println("Producer Thread"+this);
        while(true){
            try {
                this.shaObj.setList();
                value++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
