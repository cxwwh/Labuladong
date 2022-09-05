package zhangjian2.BinaryTree.ganglingpian18;

/**
 * @author CXWWH
 * @create 2022-05-24-20:48
 * @
 **/
public class T104 {


    int res = 0;
    int depth = 0;

    public int maxDepth(TreeNode root) {

        traverse(root);
        return res;
    }

    public void traverse(TreeNode root){

        if( root == null){

            res = Math.max(res,depth);
            return;
        }

        depth++;
        traverse(root.left);
        traverse(root.right);
    }

    public int maxDepth2(TreeNode root) {

        if( root == null){

            return 0;
        }

        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);

        return Math.max(left,right)+1;
    }
}
