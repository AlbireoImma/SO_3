public class Promotor extends Thread{
    private int atendidos=0;
    private Venta venta = null;
    Promotor(Venta venta){
        this.venta = venta;
    }
    public void run(){
        Thread.currentThread().setName("Promotor");
        while (true) {
            
        }
    }
}