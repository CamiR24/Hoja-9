package src;

import java.io.*;
import java.util.*;

public class ReaderFile{

    public List<String> read(String fileName) throws IOException {
        List<String> line = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String linea;
        while ((linea = reader.readLine()) != null) {
            line.add(linea);
        }
        reader.close();
        return line;
    }

    public void write(String fileName, List<String> line) throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(fileName));
        for (String linea : line) {
            escritor.write(linea);
            escritor.newLine(); // Agregar cambio de línea después de cada línea escrita
        }
        escritor.close();
    }
}
