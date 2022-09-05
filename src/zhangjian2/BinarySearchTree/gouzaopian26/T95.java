package zhangjian2.BinarySearchTree.gouzaopian26;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-07-06-10:11
 * @
 **/
public class T95 {

    public List<TreeNode> generateTrees(int n) {

        if( n == 0){

            return new ArrayList<>();
        }

        return build(1, n);
    }

    public List<TreeNode> build(int lo, int hi){

        List<TreeNode> res = new ArrayList<>();

        if(lo > hi){

            res.add( null);
            return res;
        }

        //穷举所有root节点
        for(int i = lo; i <= hi; i++){

            //递归构造出所有左右子树的所有合法BST
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i+1,hi);

            //将以root为根的左右子树进行穷举
            for(TreeNode left : leftTree){

                for(TreeNode right : rightTree){

                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;
                    res.add( root);
                }
            }
        }

        return res;
    }
}
