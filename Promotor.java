import java.util.Scanner;
public class Promotor extends Thread{
    private int atendidos;
    private Venta venta = null;
    Scanner reader = null;
    Promotor(Venta venta, Scanner reader){
        this.venta = venta;
        this.reader = reader;
        this.atendidos = 0;
    }
    public void run(){
        Thread.currentThread().setName("Promotor");
        while (true) {
            if (venta.GetTurno()==1) {
                System.out.println("[Promotor] '"+venta.GetCliente()+", tengo los siguientes productos para ofrecerte'");
                venta.PrintProductos();
                System.out.println("Ingrese una opcion [Use cualquier otra para cancelar]: ");
                String seleccion = reader.next();
                int n = Integer.parseInt(seleccion);
                if (n == 1) {
                    venta.SetProducto(venta.GetNombreProductos(n-1));
                    venta.SetValor(venta.GetPrecioProductos(n-1));
                    atendidos++;
                    venta.AddTurno();
                } else if (n == 2) {
                    venta.SetProducto(venta.GetNombreProductos(n-1));
                    venta.SetValor(venta.GetPrecioProductos(n-1));
                    atendidos++;
                    venta.AddTurno();
                } else if (n == 3) {
                    venta.SetProducto(venta.GetNombreProductos(n-1));
                    venta.SetValor(venta.GetPrecioProductos(n-1));
                    atendidos++;
                    venta.AddTurno();
                } else {
                    atendidos++;
                    venta.SetTurno(0);
                }
                reader.close();
                
            }
        }
    }
}