public class Caja extends Thread{
    private int monto;
    public void run(){
        Thread.currentThread().setName("Caja");
        System.out.println("Caja en marcha");
    }
}