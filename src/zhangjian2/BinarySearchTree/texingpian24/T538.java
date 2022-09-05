package zhangjian2.BinarySearchTree.texingpian24;

/**
 * @author CXWWH
 * @create 2022-07-02-8:11
 * @
 **/
public class T538 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {

        traverse( root);
        return root;
    }

    public void traverse(TreeNode root){

        if( root == null){

            return;
        }

        traverse( root.right);

        sum += root.val;
        root.val = sum;
        traverse( root.left);
    }
}
