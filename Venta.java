import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Venta {
    private int turno = 0;
    private int valor = 0;
    private String cliente = "";
    private String producto = "";
    private String fecha = "";
    private Productos productos = new Productos();

    public String GetFecha() {
        return new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(Calendar.getInstance().getTime());
    }

    public void SetValor(int A) {
        synchronized (this) {
            valor = A;
        }
    }

    public void Reset(){
        synchronized(this){
            turno = 0;
            valor = 0;
            cliente = "";
            producto = "";
            fecha = "";
        }
    }

    public void SetCliente(String A) {
        synchronized (this) {
            cliente = A;
        }
    }

    public void SetFecha() {
        synchronized (this) {
            fecha = GetFecha();
        }
    }

    public void SetProducto(String A) {
        synchronized (this) {
            producto = A;
        }
    }

    public void AddTurno() {
        synchronized (this) {
            turno++;
            turno %= 4;
        }
    }

    public void SetTurno(int A) {
        synchronized (this) {
            turno = A;
        }
    }

    public int GetTurno() {
        synchronized (this) {
            return turno;
        }
    }

    public int GetValor() {
        synchronized (this) {
            return valor;
        }
    }

    public String GetCliente() {
        synchronized (this) {
            return cliente;
        }
    }

    public String GetProducto() {
        synchronized (this) {
            return producto;
        }
    }

    public String GetFecha_() {
        synchronized (this) {
            return fecha;
        }
    }

    public void PrintProductos() {
        productos.PrintProductos();
    }

    public String GetNombreProductos(int index) {
        synchronized (this) {
            return productos.GetNombre(index);
        }
    }

    public int GetPrecioProductos(int index) {
        synchronized (this) {
            return productos.GetPrecio(index);
        }
    }
}