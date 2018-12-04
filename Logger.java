import java.io.*;
import java.util.Scanner;

public class Logger extends Thread {
    private Promotor promotor = null;
    private Venta venta = null;
    private Caja caja = null;
    private Empaque empaque = null;
    private PrintStream out_1 = null;
    private PrintStream out_2 = null;
    private PrintStream out_3 = null;
    private PrintStream out_4 = null;
    private Scanner reader = null;

    Logger(Promotor promotor, Venta venta, Caja caja, Empaque empaque, Scanner reader){
        this.caja = caja;
        this.empaque = empaque;
        this.venta = venta;
        this.promotor = promotor;
        this.reader = reader;
    }

    public void run(){
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();        
            }
            try {
                out_1 = new PrintStream(new FileOutputStream("logs/log_Promotor.txt", true));
                out_2 = new PrintStream(new FileOutputStream("logs/log_Caja.txt", true));
                out_3 = new PrintStream(new FileOutputStream("logs/log_Empaque.txt", true));
                out_4 = new PrintStream(new FileOutputStream("logs/log_Cliente.txt", true));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                out_1.println("["+venta.GetFecha()+"] Atendidos: " + promotor.GetAtendidos() + " Atendiendo actualmente: "+ venta.GetCliente());
                out_2.println("["+venta.GetFecha()+"] Dinero en caja: "+caja.GetMonto());
                out_3.println("["+venta.GetFecha()+"] Empacados: "+empaque.GetEmpacados());
                out_4.println("["+venta.GetFecha()+"] Cliente actual: "+venta.GetCliente());
            }
        }
    }
}