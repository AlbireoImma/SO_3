import java.util.Scanner;

public class Empaque extends Thread {
    private int empacados = 0;
    private Venta venta = null;
    Scanner reader = null;

    Empaque(Venta venta, Scanner reader) {
        this.venta = venta;
        this.reader = reader;
    }

    public void run() {
        Thread.currentThread().setName("Empaque");
        while (true) {
            if (venta.GetTurno() == 3) {
                System.out.println("[" + venta.GetFecha() + "][Empaque] Paso por Empaque");
                venta.AddTurno();
            }
        }
    }
}