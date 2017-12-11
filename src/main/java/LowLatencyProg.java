public class LowLatencyProg {

    Employee e = new Employee(1,"nn","rr",12.3);
    public static void main(String[] args) {

        LowLatencyProg lowLL= new LowLatencyProg();
        System.out.println("BisMillah Irrahman Nirrahim");
        int i=0;
        while(true){
            lowLL.e = new Employee(i,"nn","rr",12.3);
            String x = "hello"+i;
            i++;
            System.out.println(x);
        }
    }

}
