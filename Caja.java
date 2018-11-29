public class Caja extends Thread{
    private int monto=0;
    private Venta venta = null;
    public void run(){
        Thread.currentThread().setName("Caja");
        System.out.println("Caja en marcha");
    }
}