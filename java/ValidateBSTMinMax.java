package java;

/**
 * Binary Search Tree Validation using Min-Max bounds
 * 
 * BST Property: For any node:
 * - All nodes in left subtree must be < node.data (strictly less)
 * - All nodes in right subtree must be > node.data (strictly greater)
 */
public class ValidateBSTMinMax {
    
    static class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    /**
     * APPROACH 1: Strict inequality using node.data - 1
     * 
     * This enforces: left subtree < parent, right subtree > parent
     * 
     * ⚠️ Potential issue: Integer overflow if node.data == Integer.MIN_VALUE
     *    Then node.data - 1 would overflow to Integer.MAX_VALUE
     */
    static boolean isBSTUtil_Strict(Node node, int min, int max) {
        if (node == null) return true;

        // Check if current node is within valid range
        if (node.data < min || node.data > max) return false;

        // Recursively check subtrees with STRICT bounds
        // Left: must be < node.data, so max is node.data - 1
        // Right: must be > node.data, so min is node.data + 1
        return isBSTUtil_Strict(node.left, min, node.data - 1) &&
               isBSTUtil_Strict(node.right, node.data + 1, max);
    }
    
    /**
     * APPROACH 2: Non-strict bounds (more common, avoids overflow)
     * 
     * Uses node.data as boundary, but checks with strict comparison
     */
    static boolean isBSTUtil_NonStrict(Node node, long min, long max) {
        if (node == null) return true;

        // Check if current node violates BST property
        // Must be strictly greater than min and strictly less than max
        if (node.data <= min || node.data >= max) return false;

        // Recursively check subtrees
        // Left: values must be < node.data, so max becomes node.data
        // Right: values must be > node.data, so min becomes node.data
        return isBSTUtil_NonStrict(node.left, min, node.data) &&
               isBSTUtil_NonStrict(node.right, node.data, max);
    }
    
    // Wrapper for strict approach
    static boolean isBST_Strict(Node root) {
        return isBSTUtil_Strict(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    // Wrapper for non-strict approach (safer, uses long to avoid overflow)
    static boolean isBST_NonStrict(Node root) {
        return isBSTUtil_NonStrict(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public static void main(String[] args) {
        // Test case 1: Valid BST
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);
        
        System.out.println("Test 1 (Valid BST):");
        System.out.println("Strict approach: " + isBST_Strict(root1));
        System.out.println("Non-strict approach: " + isBST_NonStrict(root1));
        
        // Test case 2: Invalid BST (left child > parent)
        Node root2 = new Node(5);
        root2.left = new Node(6);  // Invalid: 6 > 5
        
        System.out.println("\nTest 2 (Invalid BST - left > parent):");
        System.out.println("Strict approach: " + isBST_Strict(root2));
        System.out.println("Non-strict approach: " + isBST_NonStrict(root2));
        
        // Test case 3: Invalid BST (right child < parent)
        Node root3 = new Node(5);
        root3.right = new Node(4);  // Invalid: 4 < 5
        
        System.out.println("\nTest 3 (Invalid BST - right < parent):");
        System.out.println("Strict approach: " + isBST_Strict(root3));
        System.out.println("Non-strict approach: " + isBST_NonStrict(root3));
        
        // Test case 4: Edge case with Integer.MIN_VALUE (potential overflow)
        Node root4 = new Node(Integer.MIN_VALUE);
        root4.right = new Node(Integer.MIN_VALUE + 1);
        
        System.out.println("\nTest 4 (Edge case with MIN_VALUE):");
        System.out.println("Strict approach: " + isBST_Strict(root4));
        System.out.println("Non-strict approach: " + isBST_NonStrict(root4));
    }
}





