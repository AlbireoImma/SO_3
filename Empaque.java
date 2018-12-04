import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Empaque extends Thread {
    private int empacados = 0;
    private Venta venta = null;
    private Scanner reader = null;
    private PrintStream out = null;

    Empaque(Venta venta, Scanner reader) {
        this.venta = venta;
        this.reader = reader;
    }

    public int GetEmpacados(){
        synchronized(this){
            return empacados;
        }
    }

    public void run() {
        Thread.currentThread().setName("Empaque");
        try {
            out = new PrintStream(new FileOutputStream("logs/verbose_Empaque.txt", true));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.println("=============================== "+ venta.GetFecha() +" ===============================");
        }
        while (true) {
            if (venta.GetTurno() == 3) {
                empacados++;
                String fase_1 = "[" + venta.GetFecha() + "][Empaque] Empaque de " + venta.GetProducto();
                String fase_2 = "[" + venta.GetFecha() + "][Empaque] Productos empacados: " + empacados;
                System.out.println(fase_1);
                System.out.println(fase_2);
                try {
                    out = new PrintStream(new FileOutputStream("logs/verbose_Empaque.txt", true));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    out.println(fase_1);
                    out.println(fase_2);
                }
                try {
                    out = new PrintStream(new FileOutputStream("logs/verbose_Cliente.txt", true));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    out.println("[" + venta.GetFecha() + "][Cliente] " + venta.GetCliente() + " sale de la tienda con un paquete con "+ venta.GetProducto());
                }
                venta.AddTurno();
            }
        }
    }
}