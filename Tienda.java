import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Venta venta = new Venta();
        Promotor promotor = new Promotor(venta,reader);
        Caja caja = new Caja(venta,reader);
        Empaque empaque = new Empaque(venta,reader);
        promotor.start();
        caja.start();
        empaque.start();
        while (true) {
            if (venta.GetTurno()==0) {
                System.out.println("[Cliente] Entra a la tienda");
                System.out.println("Ingrese su nombre: ");
                String nombre = reader.next();
                venta.SetCliente(nombre);
                venta.AddTurno();
            }
        }
    }
}