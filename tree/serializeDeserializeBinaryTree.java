import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#").append(",");
            return;
        }
        builder.append(node.val).append(",");
        serialize(node.left, builder);
        serialize(node.right, builder);
    }

    public TreeNode deserialize(String data) {
        List<String> tokens = Arrays.asList(data.split(","));
        Iterator<String> iter = tokens.iterator();
        return deserialize(iter);
    }

    private TreeNode deserialize(Iterator<String> iter) {
        String next = iter.next();
        if (next.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(next));
        node.left = deserialize(iter);
        node.right = deserialize(iter);

        return node;
    }

    public final static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Solution solution = new Solution();
        String result = solution.serialize(root);
        TreeNode new_root = solution.deserialize(result);
        System.out.println(solution.serialize(new_root));
    }
}

