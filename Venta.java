public class Venta {
    private int turno=0;
    private int valor=0;
    private String cliente="";
    private String producto="";
    private String fecha="";
    
    public String GetFecha(){
        return new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(Calendar.getInstance().getTime());
    }
    public void SetValor(int A){
        synchronized(this){
            valor = A;
        }
    }
    public void SetCliente(String A){
        synchronized(this){
            cliente = A;
        }
    }
    public void SetFecha(){
        synchronized(this){
            fecha = GetFecha();
        }
    }
    public void SetProducto(String A){
        producto = A;
    }
}

//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());