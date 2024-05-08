package src;

import java.util.*;

public class HuffmanTree {
    public static class Node {
        char character;
        int frequency;
        Node left = null, right = null;

        Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        Node(Node left, Node right) {
            this.frequency = left.frequency + right.frequency;
            this.left = left;
            this.right = right;
        }
    }

    public static Node buildTree(Map<Character, Integer> freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node(left, right));
        }

        return pq.poll();
    }

    public static void buildHuffmanCodes(Node root, String string, Map<Character, String> huffmanCodes) {
        
        throw new UnsupportedOperationException("Unimplemented method 'buildHuffmanCodes'");
    }

}
