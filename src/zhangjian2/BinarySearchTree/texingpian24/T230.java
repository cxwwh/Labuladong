package zhangjian2.BinarySearchTree.texingpian24;

/**
 * @author CXWWH
 * @create 2022-07-02-8:11
 * @
 **/
public class T230 {

    int res;
    int rank;
    public int kthSmallest(TreeNode root, int k) {

        traverse(root, k);
        return res;
    }

    public void traverse(TreeNode root, int k){

        if( root == null){

            return;
        }
        traverse(root.left, k);

        rank++;
        if( rank == k){

            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
