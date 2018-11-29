import java.awt.List;

public class Productos{
    private List<String> lista_nombres;
    private List<Integer> lista_precios;

    public Productos(){
        lista_nombres = new Array.asList("Polera","Chalas","Zapatillas");
        lista_precios = new Array.asList(10000,8500,25000);
    }

    public void PrintProductos(){
        for (int i = 0; i < 3; i++) {
            System.out.println(i+1 + ")" + lista_nombres.getItem(i) + "\t" + lista_precios.getItem(i));
        }
    }

    public int GetPrecio(int index){
        return lista_precios.getItem(index);
    }

    public String GetNombre(int index){
        return lista_nombres.getItem(index);
    }
}