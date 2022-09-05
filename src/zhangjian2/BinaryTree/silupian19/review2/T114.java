package zhangjian2.BinaryTree.silupian19.review2;

/**
 * @author CXWWH
 * @create 2022-06-09-21:57
 * @
 **/
public class T114 {

    //定义：flatten(TreeNode root)方法可以把以root为根节点的二叉树伸展为一个链表
    public void flatten(TreeNode root){

        if( root == null){

            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode r = root;
        while( r.right != null){

            r = r.right;
        }

        r.right = right;
    }

}
