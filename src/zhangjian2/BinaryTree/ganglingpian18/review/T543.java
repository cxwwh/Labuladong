package zhangjian2.BinaryTree.ganglingpian18.review;


/**
 * @author CXWWH
 * @create 2022-06-06-23:14
 * @
 **/
public class T543 {


    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        getMaxDep(root);
        return maxD;
    }

    //定义：getMaxDep(TreeNode root)方法返回以root为根节点的左右子树深度的最大值
    public int getMaxDep(TreeNode root){

        if( root == null){

            return 0;
        }

        int left = getMaxDep(root.left);
        int right = getMaxDep(root.right);

        int d = left + right;
        maxD = Math.max(maxD,d);

        return Math.max(left,right) + 1;
    }
}
