package zhangjian2.BinaryTree.silupian19.review2;


/**
 * @author CXWWH
 * @create 2022-06-09-21:32
 * @
 **/
public class T226 {

    public TreeNode invertTree(TreeNode root) {

        traverse( root);
        return root;
    }

    public void traverse( TreeNode root){

        if( root == null){

            return;
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        traverse(root.left);
        traverse(root.right);
    }

    //递归方法
    //定义：invertTree2(TreeNode root)方法将以root为节点的二叉树的左右子树交换，然后返回root节点
    public TreeNode invertTree2(TreeNode root) {

        if( root == null){

            return null;
        }

        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
