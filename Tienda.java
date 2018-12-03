import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Venta venta = new Venta();
        Promotor promotor = new Promotor(venta, reader);
        Caja caja = new Caja(venta, reader);
        Empaque empaque = new Empaque(venta, reader);
        PrintStream cliente = null;
        promotor.start();
        caja.start();
        empaque.start();
        try {
            cliente = new PrintStream(new FileOutputStream("log_Cliente.txt", true));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cliente.println("=============================== "+ venta.GetFecha() +" ===============================");
            cliente.close();
        }
        while (true) {
            if (venta.GetTurno() == 0) {
                System.out.println("[" + venta.GetFecha() + "][Cliente] Entra a la tienda");
                System.out.println("[Cliente] Ingrese su nombre: ");
                String nombre = reader.next();
                venta.SetCliente(nombre);
                try {
                    cliente = new PrintStream(new FileOutputStream("log_Cliente.txt", true));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    cliente.println("[" + venta.GetFecha() + "][Cliente] " + nombre + " entra a la tienda");
                }
                venta.AddTurno();
            }
        }
    }
}