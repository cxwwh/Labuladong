package zhangjian2.BinaryTree.ganglingpian18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-05-24-21:57
 * @
 **/
public class T144 {


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if( root == null){

            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));

        return res;
    }


    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal2(TreeNode root) {

        treverse(root);
        return result;
    }

    public void treverse(TreeNode root){

        if( root == null){

            return;
        }
        result.add(root.val);
        treverse(root.left);
        treverse(root.right);
    }
}
