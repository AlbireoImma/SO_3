import java.util.Scanner;

public class Caja extends Thread{
    private int monto=0;
    private Venta venta = null;
    Scanner reader = null;
    Caja(Venta venta,Scanner reader){
        this.venta = venta;
        this.reader = reader;
    }
    public void run(){
        Thread.currentThread().setName("Caja");
        System.out.println("Caja en marcha");
    }
}