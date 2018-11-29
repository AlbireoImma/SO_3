public class Promotor extends Thread{
    private int atendidos=0;
    private Venta venta = null;
    public void run(){
        Thread.currentThread().setName("Promotor");
        System.out.println("Promotor en marcha");
    }
}