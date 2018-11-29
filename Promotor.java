public class Promotor extends Thread{
    private int atendidos;
    public void run(){
        Thread.currentThread().setName("Promotor");
        System.out.println("Promotor en marcha");
    }
}