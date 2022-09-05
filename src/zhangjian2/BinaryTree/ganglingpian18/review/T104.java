package zhangjian2.BinaryTree.ganglingpian18.review;


/**
 * @author CXWWH
 * @create 2022-06-06-22:26
 * @
 **/
public class T104 {

    //使用遍历做
    int myDepth = 0;
    int maxDep = 0;
    public int maxDepth(TreeNode root) {

        traverse(root);
        return maxDep;
    }

    public void traverse(TreeNode root){

        if( root == null){

            maxDep = Math.max(maxDep,myDepth);
            return;
        }

        myDepth++;
        traverse(root.left);
        traverse(root.right);
        myDepth--;
    }


    //使用递归做
    //定义：maxDepth2(TreeNode root)方法返回以root为根节点的二叉树的最大深度
    public int maxDepth2(TreeNode root) {

        if( root == null){

            return 0;
        }

        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);

        return Math.max(left, right) + 1;
    }
}
