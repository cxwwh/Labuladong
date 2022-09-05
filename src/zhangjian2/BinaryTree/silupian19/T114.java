package zhangjian2.BinaryTree.silupian19;

/**
 * @author CXWWH
 * @create 2022-05-28-22:29
 * @
 **/
public class T114 {

    TreeNode head = new TreeNode(-1);
    TreeNode h = head;
    public void flatten(TreeNode root) {

        traverse(root);
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

        //将right挂在left最末端的right
        //如果此时left==null
        //直接将right挂在root右面
        if( left == null){

            root.right = right;
            return;//不要忘记返回
        }

        //如果left!=null
        //那么就遍历left.right直到末尾
        while(left.right != null){

            left = left.right;
        }

        left.right = right;
    }
}
