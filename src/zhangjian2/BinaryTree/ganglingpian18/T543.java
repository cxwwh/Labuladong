package zhangjian2.BinaryTree.ganglingpian18;

/**
 * @author CXWWH
 * @create 2022-05-24-22:19
 * @
 **/
public class T543 {

    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        traverse( root );
        return maxD;
    }

    //计算每个节点的左子树和右子树的最大深度之和
    public void traverse(TreeNode root){

        if( root == null){

            return;
        }

        //计算root节点的左子树和右子树的最大深度
        int left = maxDepth( root.left);
        int right = maxDepth( root.right);

        if( maxD < (left + right)){

            maxD = (left + right);
        }

        traverse(root.left);
        traverse(root.right);
    }

    //计算以各个节点为根节点的二叉树的深度
    public int maxDepth(TreeNode node){

        if( node == null){

            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        return Math.max(left,right) + 1;
    }


    //***************************************************
    int maxD2 = 0;
    public int diameterOfBinaryTree2(TreeNode root) {

        maxDepth2( root );
        return maxD2;
    }

    //计算以node为根节点的子树的最大深度
    public int maxDepth2(TreeNode node){

        if( node == null){

            return 0;
        }

        //计算node节点的左右子树的最大深度之和
        int left = maxDepth2(node.left);
        int right = maxDepth2(node.right);

        if( maxD2 < (left + right)){

            maxD2 = (left + right);
        }

        //别忘了+1
        return Math.max(left,right) + 1;
    }
}
