public class Empaque extends Thread{
    private int empacados;
    public void run(){
        Thread.currentThread().setName("Empaque");
        System.out.println("Tienda en marcha");
    }
}