package TESTS;

import src.HuffmanTree.Node;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;

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
}
