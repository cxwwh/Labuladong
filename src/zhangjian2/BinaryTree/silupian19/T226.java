package zhangjian2.BinaryTree.silupian19;

/**
 * @author CXWWH
 * @create 2022-05-28-21:30
 * @
 **/
public class T226 {

    public TreeNode invertTree(TreeNode root) {

        traverse(root);
        return root;
    }

    public void traverse(TreeNode root){

        if( root == null){

            return;
        }

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        traverse(root.left);
        traverse(root.right);

    }

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
