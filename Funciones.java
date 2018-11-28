import java.io.*;

public class Funciones {
    public static void main(String[] args) {
        String filename = "funciones.txt";
        String line = null;

        try {
            // Abriendo el archivo funciones.txt
            FileReader lector = new FileReader(filename)
            // Buffer de lectura

        } 
        catch (FileNotFoundException ex) {
            // Error en apertura del archivo
            System.out.println(
                "No se pudo abrir el archivo '" +
                filename + "'");
        }
        catch (IOException ex) {
            // Error en la lectura del archivo
            System.out.println(
                "Error leyendo el archivo '" +
                filename + "'");
        }
    }
}