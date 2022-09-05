package zhangjian2.BinaryTree.silupian19.review;


/**
 * @author CXWWH
 * @create 2022-06-07-21:51
 * @
 **/
public class T114 {

    TreeNode head = new TreeNode(-1);
    TreeNode h = head;
    public void flatten(TreeNode root) {

        traverse(root);
        root = head.right;
    }

    public void traverse(TreeNode root){

        if( root == null){

            return;
        }

        h.right = new TreeNode(root.val);
        h = h.right;

        traverse(root.left);
        traverse(root.right);
    }


    //定义flatten2(TreeNode root)方法可以将以root为根节点的二叉树拉开
    public void flatten2(TreeNode root) {

        if( root == null){

            return;
        }
        flatten2(root.left);
        flatten2(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        if( left == null){

            root.right = right;
            return;
        }

        while( left.right != null){

            left = left.right;
        }

        left.right = right;
    }
}
