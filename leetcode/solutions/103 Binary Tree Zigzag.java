import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean leftToRight = false;

    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();

        // 从queue往level中加的时候判断怎么加
        if (leftToRight) {
          level.add(0, node.val);
        } else {
          level.add(node.val);
        }

        // 往queue里面加的时候正常添加
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      res.add(level);
      leftToRight = !leftToRight;
    }

    return res;
  }

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
}