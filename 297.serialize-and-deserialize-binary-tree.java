
/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String SEP = ",";
    private String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serialize(root, sb);
        return sb.toString();
    }

    StringBuilder sb = new StringBuilder();

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    int index = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return build(data.split(SEP));
    }

    private TreeNode build(String[] data) {
        if (index >= data.length) {
            return null;
        }
        if (data[index].equals(NULL)) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(data[index++]));
        node.left = build(data);
        node.right = build(data);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
