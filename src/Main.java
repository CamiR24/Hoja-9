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
        //------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        boolean salir = false; // Bandera para salir del ciclo

        while (!salir) {
            System.out.println("------ MENU ------");
            System.out.println("1. Comprimir archivo\n2. Descomprimir archivo\n3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            
            switch (opcion) {
                case 1:
                    comprimir(reader); // Llamar al método de compresión
                    break;
                case 2:
                    descomprimir(reader); // Llamar al método de descompresión
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
            // Escribir los códigos de Huffman en un archivo
            /*StringBuilder codigosHuffman = new StringBuilder();
            for (Map.Entry<Character, String> entry : codigos.entrySet()) {
                codigosHuffman.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            lector.write("codigos.huff", codigosHuffman.toString());*/

            System.out.println("Compresión y descompresión completadas con éxito.");
        }

        public static void comprimir(ReaderFile reader){

        }

        public static void descomprimir(ReaderFile reader){

        }
    }
