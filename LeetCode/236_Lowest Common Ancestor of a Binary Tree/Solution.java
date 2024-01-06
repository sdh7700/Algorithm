/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int big;
    int small;

    if (p.val > q.val) {
      big = p.val;
      small = q.val;
    } else {
      big = q.val;
      small = p.val;
    }

    while (root != null) {
      if (root.val >= small && root.val <= big) {
        return root;
      } else if (root.val > big) {
        root = root.left;
      } else {
        root = root.right;
      }
    }

    return null;
  }
}