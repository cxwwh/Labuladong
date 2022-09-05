package zhangjian2.BinaryTree.gouzaopian20;

/**
 * @author CXWWH
 * @create 2022-06-12-9:18
 * @
 **/
public class T654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {


        return build(nums,0,nums.length-1);
    }

    //定义build(int[] nums, int lo, int hi)方法返回一个以nums中指定范围内的元素构成的一个最大二叉树
    public TreeNode build(int[] nums, int lo, int hi){

        if (lo > hi){

            return null;
        }

        int index = -1;
        int maxVal = Integer.MIN_VALUE;

        for(int i = lo; i <= hi; i++){

            if( nums[i] > maxVal){

                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode( maxVal);

        root.left = build(nums,lo,index-1);
        root.right = build(nums,index+1,hi);

        return root;
    }
}
