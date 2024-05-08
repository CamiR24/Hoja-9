package src;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ReaderFile reader = new ReaderFile();
        try {
            List<String> line = reader.read("archivo.txt");
            for (String linea : line) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }

            // Escribir los códigos de Huffman en un archivo
            /*StringBuilder codigosHuffman = new StringBuilder();
            for (Map.Entry<Character, String> entry : codigos.entrySet()) {
                codigosHuffman.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            lector.write("codigos.huff", codigosHuffman.toString());*/

            System.out.println("Compresión y descompresión completadas con éxito.");
        }
    }
