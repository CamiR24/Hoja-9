package src;

import java.io.*;
import java.util.*;

import src.HuffmanTree.*;


public class Main {
    public static void main(String[] args) throws IOException {
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
            
            String compressedText = "";
            switch (opcion) {
                case 1:
                    compressedText = comprimir(reader); // Llamar al método de compresión
                    break;
                case 2:
                    descomprimir(compressedText, RootNode(null)); // Llamar al método de descompresión
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

        public static String comprimir(ReaderFile reader) throws IOException{
            TextToString converter = new TextToString();
            String text = converter.readFileToString("archivo.txt");


            Map<Character, Integer> freq = FreqMap(text);
            Node root = RootNode(freq);
            Map<Character, String> huffmanCodes = HuffmanCodes(root);

            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray()) {
                sb.append(huffmanCodes.get(c));
            }

            return sb.toString();
        }

        public static String descomprimir(String compressedText, Node root){
            StringBuilder result = new StringBuilder();
            Node current = root;
            for (char bit : compressedText.toCharArray()) {
                if (bit == '0') {
                    current = current.left;
                } else if (bit == '1') {
                    current = current.right;
                }

                if (current.left == null && current.right == null) {
                    result.append(current.character);
                    current = root;
                }
            }

            return result.toString();
        }





        private static Map<Character, Integer> FreqMap(String text){
            Map<Character, Integer> freq = new HashMap<>();
            for (char c : text.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }

            return freq;
        }

        private static Node RootNode(Map<Character, Integer> freq){
            HuffmanTree.Node root = HuffmanTree.buildTree(freq);

            return root;
        }

        private static Map<Character, String> HuffmanCodes(Node root){
            Map<Character, String> huffmanCodes = new HashMap<>();
            HuffmanTree.buildHuffmanCodes(root, "", huffmanCodes);

            return huffmanCodes;
        }
    }
