package zhangjian2.Graph.BFS;

/**
 * @author CXWWH
 * @create 2022-05-24-20:49
 * @
 **/

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
