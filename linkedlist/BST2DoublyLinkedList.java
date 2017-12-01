import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}

class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    // Recursion
    public DoublyListNode bstToDoublyList(TreeNode root) {
        return bstToDoublyListHelper(root)[0];
    }

    private DoublyListNode[] bstToDoublyListHelper(TreeNode node) {
        if (node == null) {
            return new DoublyListNode[]{null, null};
        }
        
        DoublyListNode head = new DoublyListNode(node.val);
        DoublyListNode tail = head;
        if (node.left != null) {
            DoublyListNode left[] = bstToDoublyListHelper(node.left);
            DoublyListNode tmp = head;
            head = left[0];
            left[1].next = tmp;
            tmp.prev = left[1];
            tail = tmp;
        }

        if (node.right != null) {
            DoublyListNode right[] = bstToDoublyListHelper(node.right);
            tail.next = right[0];
            right[0].prev = tail;
            tail = right[1];
        }

        return new DoublyListNode[]{head, tail};
    }

    private void print(DoublyListNode head) {
        DoublyListNode tail = null;
        while (head != null) {
            System.out.print(head.val);
            System.out.print(" ");
            tail = head;
            head = head.next;
        }
        System.out.println();
        while (tail != null) {
            System.out.print(tail.val);
            System.out.print(" ");
            tail = tail.prev;
        }
    }

    // Iteration
    public DoublyListNode bstToDoublyListIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        DoublyListNode next = null;
        while (root != null) {
            stack.push(root);
            root = root.right;
        }
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            DoublyListNode dln = new DoublyListNode(top.val);
            dln.next = next;
            if (next != null) {
                next.prev = dln;
            }
            next = dln;
            TreeNode right = top.left;
            while (right != null) {
                stack.push(right);
                right = right.right;
            }
        }
        return next;
    }

    public final static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right = new TreeNode(8);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(10);
        tree.right.right.right = new TreeNode(15);

        Solution solution = new Solution();
        DoublyListNode head = solution.bstToDoublyList(tree);
        DoublyListNode headiter = solution.bstToDoublyListIteration(tree);
        solution.print(head);
        System.out.println();
        solution.print(headiter);
    }
}
