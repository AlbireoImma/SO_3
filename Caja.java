import java.util.Scanner;

public class Caja extends Thread {
    private int monto = 0;
    private Venta venta = null;
    Scanner reader = null;

    Caja(Venta venta, Scanner reader) {
        this.venta = venta;
        this.reader = reader;
    }

    public void run() {
        Thread.currentThread().setName("Caja");
        while (true) {
            if (venta.GetTurno() == 2) {
                System.out.println("[" + venta.GetFecha() + "][Caja] Atiende a " + venta.GetCliente()
                        + ", por un valor de $" + venta.GetValor());
                System.out.println("\t1) Efectivo");
                System.out.println("\t2) Credito");
                System.out.println("[" + venta.GetFecha() + "][Caja] Seleccione una opcion para pagar:");
                String seleccion = reader.next();
                int n = Integer.parseInt(seleccion);
                if (n == 1) {
                    System.out.println("[" + venta.GetFecha() + "][Caja] Recibio pago por un valor de $"
                            + venta.GetValor() + " via efectivo");
                    monto += venta.GetValor();
                    System.out.println(
                            "[" + venta.GetFecha() + "][Caja] Total:$" + monto + " Abono:$" + venta.GetValor());
                    venta.AddTurno();
                } else if (n == 2) {
                    System.out.println("[" + venta.GetFecha() + "][Caja] Recibio pago por un valor de $"
                            + venta.GetValor() + " via credito");
                    monto += venta.GetValor();
                    System.out.println(
                            "[" + venta.GetFecha() + "][Caja] Total:$" + monto + " Abono:$" + venta.GetValor());
                    venta.AddTurno();
                } else {
                    System.out.println("[" + venta.GetFecha() + "][Caja] No Recibio Pago");
                    System.out.println("[" + venta.GetFecha() + "][Caja] Total:$" + monto + " Abono:$0");
                    venta.SetTurno(0);
                }
            }
        }
    }
}