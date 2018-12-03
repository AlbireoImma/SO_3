import java.io.*;
import java.util.*;

public class Funciones {
    public static void main(String[] args) {
        String filename = "funciones.txt";
        List<String> funciones = new ArrayList<String>();
        try {
            FileReader lector = new FileReader(filename);
            BufferedReader reader = new BufferedReader(lector);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                funciones.add(line);
            }
            reader.close();
            return;
        } catch (Exception e) {
            System.err.format("Excepcion tratando de leer o abrir: '%s'.", filename);
            e.printStackTrace();
            return;
        }

    }
}