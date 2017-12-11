public class ConsumerThrd implements Runnable {

    SharedObject shaObj = null;
    ConsumerThrd(SharedObject sharedObject){
        this.shaObj = sharedObject;
    }

    @Override
    public void run() {
        System.out.println("Consumber thread"+this);
        while(true){
            try {
                this.shaObj.getList();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
