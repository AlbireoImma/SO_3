public class Tienda {
    public static void main(String[] args) {
        Venta venta = new Venta();
        Promotor promotor = new Promotor();
        Caja caja = new Caja();
        Empaque empaque = new Empaque();
        promotor.start();
        caja.start();
        empaque.start();
        
    }
}