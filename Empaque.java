import java.util.Scanner;

public class Empaque extends Thread{
    private int empacados=0;
    private Venta venta = null;
    Scanner reader = null;
    Empaque(Venta venta,Scanner reader){
        this.venta = venta;
        this.reader = reader;
    }
    public void run(){
        Thread.currentThread().setName("Empaque");
        System.out.println("Tienda en marcha");
    }
}