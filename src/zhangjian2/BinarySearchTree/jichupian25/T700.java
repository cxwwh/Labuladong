package zhangjian2.BinarySearchTree.jichupian25;

/**
 * @author CXWWH
 * @create 2022-07-03-9:23
 * @
 **/
public class T700 {

    TreeNode res = null;
    public TreeNode searchBST(TreeNode root, int val) {

        traverse(root,val);
        return res;
    }

    public void traverse(TreeNode root, int val){

        if( root == null){

            return;
        }

        int rootVal = root.val;
        if( val == rootVal){

            res = root;
            return;
        }else if( val < rootVal){

            traverse(root.left, val);
        }else if( val > rootVal){

            traverse(root.right, val);
        }
    }
}
