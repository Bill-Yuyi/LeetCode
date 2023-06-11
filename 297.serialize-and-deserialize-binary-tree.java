
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
    String n = "NULL";
    String spliter = ",";
    StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(n).append(spliter);
            return;
        }

        sb.append(node.val).append(spliter);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserialize(arr);
    }

    int index = 0;

    private TreeNode deserialize(String[] data) {
        if (index >= data.length) {
            return null;
        }
        if (data[index].equals(n)) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data[index]));
        index++;
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
