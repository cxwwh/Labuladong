package zhangjian2.BinarySearchTree.houxupian27;

/**
 * @author CXWWH
 * @create 2022-07-07-10:15
 * @
 **/
public class T1373 {

    int maxSum = 0;
    public int maxSumBST(TreeNode root) {

        traverse(root);
        return maxSum;
    }

    //traverse函数返回一个含有4个元素的数组
    public int[] traverse(TreeNode root){

        if( root == null){

            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        //遍历左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];
        //res[0] 1表示是BST  0表示不是BST
        //res[1] 表示树的最小值
        //res[2] 表示树的最大值
        //res[3] 表示树的所有节点之和

        //判断以root为根的二叉树是否是BST
        if( left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]){

            res[0] = 1;

            //写入以root为根的子树的最小节点值
            res[1] = Math.min(root.val, left[1]);

            //写入以root为根的子树的最大节点值
            res[2] = Math.max(root.val,right[2]);

            //写入以root为根的子树的节点值之和
            res[3] = left[3] + right[3] + root.val;

            maxSum = Math.max(maxSum, res[3]);
        }else{

            res[0] = 0;
        }

        return res;
    }
}
