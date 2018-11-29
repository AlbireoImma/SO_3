public class Empaque extends Thread{
    private int empacados=0;
    private Venta venta = null;
    public void run(){
        Thread.currentThread().setName("Empaque");
        System.out.println("Tienda en marcha");
    }
}