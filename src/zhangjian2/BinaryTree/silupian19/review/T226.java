package zhangjian2.BinaryTree.silupian19.review;

/**
 * @author CXWWH
 * @create 2022-06-07-20:57
 * @
 **/
public class T226 {

    //使用遍历实现
    public TreeNode invertTree(TreeNode root) {

        traverse(root);
        return root;
    }

    public void traverse(TreeNode root){

        if( root == null){

            return;
        }

        traverse( root.left);
        traverse(root.right);

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
    }

    //使用递归实现
    //定义invertTree2(TreeNode root)方法返回以root为根节点的二叉树的翻转子树
    public TreeNode invertTree2(TreeNode root) {

        if( root == null){

            return null;
        }

        //翻转root的左子树
        TreeNode left = invertTree2(root.left);
        //翻转root的右子树
        TreeNode right = invertTree2(root.right);

        //交换root的左右子树
        root.left = left;
        root.right = right;

        return root;
    }
}
