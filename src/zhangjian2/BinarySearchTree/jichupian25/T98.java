package zhangjian2.BinarySearchTree.jichupian25;

/**
 * @author CXWWH
 * @create 2022-07-03-9:32
 * @
 **/
public class T98 {

    public boolean isValidBST(TreeNode root) {

        return traverse(root,null,null);
    }

    public boolean traverse(TreeNode root, TreeNode min, TreeNode max){

        if( root == null){

            return true;
        }

        if( min != null && root.val <= min.val){

            return false;
        }

        if( max != null && root.val >= max.val){

            return false;
        }

        boolean left = traverse(root.left, min, root);
        boolean right = traverse(root.right,root,max);

        return left && right;
    }
}
