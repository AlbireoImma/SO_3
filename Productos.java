import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.awt.*;

public class Productos{
    private List<String> lista_nombres;
    private List<Integer> lista_precios;

    public Productos(){
        lista_nombres = new ArrayList<String>(Arrays.asList("Polera","Chalas","Zapatillas"));
        lista_precios = new ArrayList<Integer>(Arrays.asList(10000,8500,25000));
    }

    public void PrintProductos(){
        for (int i = 0; i < 3; i++) {
            System.out.println(i+1 + ")" + lista_nombres.get(i) + "\t" + lista_precios.get(i));
        }
    }

    public int GetPrecio(int index){
        return lista_precios.get(index);
    }

    public String GetNombre(int index){
        return lista_nombres.get(index);
    }
}