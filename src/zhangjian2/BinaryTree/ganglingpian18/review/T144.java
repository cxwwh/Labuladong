package zhangjian2.BinaryTree.ganglingpian18.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CXWWH
 * @create 2022-06-06-22:39
 * @
 **/
public class T144 {

    //使用遍历进行二叉树的前序遍历
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        traverse(root);
        return list;
    }

    public void traverse(TreeNode root){

        if( root == null){

            return;
        }

        list.add( root.val);
        traverse( root.left);
        traverse( root.right);
    }

    //使用递归进行二叉树的前序遍历
    //定义：preorderTraversal2(TreeNode root)返回以root为根节点的二叉树的前序遍历结果
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if( root == null){

            return list;
        }

        list.add(root.val);
        List<Integer> left = preorderTraversal2(root.left);
        list.addAll(left);
        List<Integer> right = preorderTraversal2(root.right);
        list.addAll(right);

        return list;
    }

}
