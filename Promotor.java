import java.io.*;
import java.util.Scanner;

public class Promotor extends Thread {
    private int atendidos;
    private Venta venta = null;
    private PrintStream out = null;
    private Scanner reader = null;

    Promotor(Venta venta, Scanner reader) {
        this.venta = venta;
        this.reader = reader;
        this.atendidos = 0;
    }

    public void run() {
        Thread.currentThread().setName("Promotor");
        try {
            out = new PrintStream(new FileOutputStream("log_Promotor.txt", true));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.println("=============================== "+ venta.GetFecha() +" ===============================");
        }
        while (true) {
            if (venta.GetTurno() == 1) {
                System.out.println("[" + venta.GetFecha() + "][Promotor] '" + venta.GetCliente()
                        + ", tengo los siguientes productos para ofrecerte'");
                venta.PrintProductos();
                System.out.println("Ingrese una opcion [Use cualquier otra para cancelar]: ");
                String seleccion = reader.next();
                int n = Integer.parseInt(seleccion);
                if (n == 1) {
                    venta.SetProducto(venta.GetNombreProductos(n - 1));
                    venta.SetValor(venta.GetPrecioProductos(n - 1));
                    atendidos++;
                    String fase_1 = "[" + venta.GetFecha() + "][Promotor] Atendio a " + venta.GetCliente()
                            + ", mediante la compra de " + venta.GetProducto();
                    String fase_2 = "[" + venta.GetFecha() + "][Promotor] Clientes atendidos: " + atendidos;
                    System.out.println(fase_1);
                    System.out.println(fase_2);
                    try {
                        out = new PrintStream(new FileOutputStream("log_Promotor.txt", true));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        out.println(fase_1);
                        out.println(fase_2);
                    }
                    venta.AddTurno();
                } else if (n == 2) {
                    venta.SetProducto(venta.GetNombreProductos(n - 1));
                    venta.SetValor(venta.GetPrecioProductos(n - 1));
                    atendidos++;
                    String fase_1 = "[" + venta.GetFecha() + "][Promotor] Atendio a " + venta.GetCliente()
                            + ", mediante la compra de " + venta.GetProducto();
                    String fase_2 = "[" + venta.GetFecha() + "][Promotor] Clientes atendidos: " + atendidos;
                    System.out.println(fase_1);
                    System.out.println(fase_2);
                    try {
                        out = new PrintStream(new FileOutputStream("log_Promotor.txt", true));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        out.println(fase_1);
                        out.println(fase_2);
                    }
                    venta.AddTurno();
                } else if (n == 3) {
                    venta.SetProducto(venta.GetNombreProductos(n - 1));
                    venta.SetValor(venta.GetPrecioProductos(n - 1));
                    atendidos++;
                    String fase_1 = "[" + venta.GetFecha() + "][Promotor] Atendio a " + venta.GetCliente()
                            + ", mediante la compra de " + venta.GetProducto();
                    String fase_2 = "[" + venta.GetFecha() + "][Promotor] Clientes atendidos: " + atendidos;
                    System.out.println(fase_1);
                    System.out.println(fase_2);
                    try {
                        out = new PrintStream(new FileOutputStream("log_Promotor.txt", true));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        out.println(fase_1);
                        out.println(fase_2);
                    }
                    venta.AddTurno();
                } else {
                    String fase = "[" + venta.GetFecha() + "][Promotor] Atendio a " + venta.GetCliente()
                            + " sin compra por parte del cliente";
                    System.out.println(fase);
                    try {
                        out = new PrintStream(new FileOutputStream("log_Promotor.txt", true));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        out.println(fase);
                    }
                    try {
                        out = new PrintStream(new FileOutputStream("log_Cliente.txt", true));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        out.println("[" + venta.GetFecha() + "][Cliente] " + venta.GetCliente() + " sale de la tienda");
                    }
                    venta.SetTurno(0);
                }
            }
        }
    }
}