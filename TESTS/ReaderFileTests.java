package TESTS;
import src.ReaderFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import java.io.*;
import java.util.*;

public class ReaderFileTests {
    @Test
    public void testLeerArchivo() {
        ReaderFile lector = new ReaderFile();
        try {
            List<String> lines1 = Arrays.asList("casa", "perro", "archivo", "chocolate", "programación", "otorrinolaringologo");
            List<String> lines2 = lector.read("archivo.txt");
            assertEquals("El número de líneas no coincide", lines1.size(), lines2.size());
            for (int i = 0; i < lines1.size(); i++) {
                assertEquals("Las líneas no coinciden", lines1.get(i), lines2.get(i));
            }
        } catch (IOException e) {
            fail("Se lanzó una excepción al leer el archivo: " + e.getMessage());
        }
    }

    @Test
    public void testEscribirArchivo() {
        ReaderFile reader = new ReaderFile();
        String fileName = "archivo_prueba.txt";
        List<String> lines = Arrays.asList("Primera línea", "Segunda línea", "Tercera línea");
        try {
            reader.write(fileName, lines);

            // Verificar que el archivo se haya escrito correctamente
            List<String> writtenLines = reader.read(fileName);
            assertEquals("El número de líneas no coincide", lines.size(), writtenLines.size());
            for (int i = 0; i < lines.size(); i++) {
                assertEquals("Las líneas no coinciden", lines.get(i), writtenLines.get(i));
            }
            
            // Eliminar el archivo de prueba después de la ejecución del test
            File archivo = new File(fileName);
            archivo.delete();
        } catch (IOException e) {
            fail("Se lanzó una excepción al escribir el archivo: " + e.getMessage());
        }
    }
}
