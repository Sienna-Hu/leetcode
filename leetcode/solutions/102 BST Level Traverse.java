import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BSTLevelTraverse {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      // queue的大小就是当前level有多少node -> forloop会poll完所有在当前level的node
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode curr = queue.poll();
        level.add(curr.val);
        if (curr.left != null) {
          queue.add(curr.left);
        }
        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
      res.add(level);
    }

    return res;
  }

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }
}
