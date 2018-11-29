import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Caja extends Thread {
    private int monto = 0;
    private Venta venta = null;
    private PrintStream out = null;
    private Scanner reader = null;

    Caja(Venta venta, Scanner reader) {
        this.venta = venta;
        this.reader = reader;
    }

    public void run() {
        Thread.currentThread().setName("Caja");
        while (true) {
            if (venta.GetTurno() == 2) {
                String fase_1 = "[" + venta.GetFecha() + "][Caja] Atiende a " + venta.GetCliente()
                        + ", por un valor de $" + venta.GetValor();
                System.out.println(fase_1);
                System.out.println("\t1) Efectivo");
                System.out.println("\t2) Credito");
                System.out.println("[" + venta.GetFecha() + "][Caja] Seleccione una opcion para pagar:");
                String seleccion = reader.next();
                int n = Integer.parseInt(seleccion);
                if (n == 1) {
                    String fase_2 = "[" + venta.GetFecha() + "][Caja] Recibio pago por un valor de $" + venta.GetValor()
                            + " via efectivo";
                    String fase_3 = "[" + venta.GetFecha() + "][Caja] Total:$" + monto + " Abono:$" + venta.GetValor();
                    System.out.println(fase_2);
                    monto += venta.GetValor();
                    System.out.println(fase_3);
                    try {
                        out = new PrintStream(new FileOutputStream("log_Caja.txt", true));
                    } catch (Exception e) {
                        // TODO: handle exception
                    } finally {
                        out.println(fase_2);
                        out.println(fase_3);
                    }
                    venta.AddTurno();
                } else if (n == 2) {
                    String fase_2 = "[" + venta.GetFecha() + "][Caja] Recibio pago por un valor de $" + venta.GetValor()
                            + " via credito";
                    String fase_3 = "[" + venta.GetFecha() + "][Caja] Total:$" + monto + " Abono:$" + venta.GetValor();
                    System.out.println(fase_2);
                    monto += venta.GetValor();
                    System.out.println(fase_3);
                    try {
                        out = new PrintStream(new FileOutputStream("log_Caja.txt", true));
                    } catch (Exception e) {
                        // TODO: handle exception
                    } finally {
                        out.println(fase_2);
                        out.println(fase_3);
                    }
                    venta.AddTurno();
                } else {
                    String fase_2 = "[" + venta.GetFecha() + "][Caja] No Recibio Pago";
                    String fase_3 = "[" + venta.GetFecha() + "][Caja] Total:$" + monto + " Abono:$0";
                    System.out.println(fase_2);
                    System.out.println(fase_3);
                    try {
                        out = new PrintStream(new FileOutputStream("log_Caja.txt", true));
                    } catch (Exception e) {
                        // TODO: handle exception
                    } finally {
                        out.println(fase_2);
                        out.println(fase_3);
                    }
                    venta.SetTurno(0);
                }
            }
        }
    }
}