package TESTS;

import src.HuffmanTree;
import src.HuffmanTree.Node;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTreeTests {

    @Test
    public void testSingleNodeCreation() {
        Node node = new Node('a', 5);
        assertEquals('a', node.character);
        assertEquals(5, node.frequency);
        assertNull(node.left);
        assertNull(node.right);
    }

    @Test
    public void testNodeCreationWithChildren() {
        Node left = new Node('a', 2);
        Node right = new Node('b', 3);
        Node node = new Node(left, right);
        assertEquals(5, node.frequency);
        assertSame(left, node.left);
        assertSame(right, node.right);
    }

    @Test
    public void testNodeFrequencyCalculation() {
        Node left = new Node('a', 2);
        Node right = new Node('b', 3);
        Node node = new Node(left, right);
        assertEquals(5, node.frequency);
    }

    @Test
    public void testBuildTreeSingleNode() {
        Map<Character, Integer> freq = new HashMap<>();
        freq.put('a', 5);
        Node root = HuffmanTree.buildTree(freq);
        assertEquals('a', root.character);
        assertEquals(5, root.frequency);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    public void testBuildTreeMultipleNodes() {
        Map<Character, Integer> freq = new HashMap<>();
        freq.put('a', 5);
        freq.put('b', 3);
        freq.put('c', 2);
        Node root = HuffmanTree.buildTree(freq);
        assertNotNull(root);
    }

}
