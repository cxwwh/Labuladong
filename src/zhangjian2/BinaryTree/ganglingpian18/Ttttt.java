package zhangjian2.BinaryTree.ganglingpian18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author CXWWH
 * @create 2022-05-25-21:14
 * @
 **/
public class Ttttt {

    //前序遍历  遍历一遍二叉树实现
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> preOrderTraverse(TreeNode root){

        traverse(root);
        return res;
    }

    public void traverse(TreeNode node){

        if( node == null){

            return;
        }

        res.add(node);
        traverse(node.left);
        traverse(node.right);
    }

    //前序遍历  通过递归实现
    public List<TreeNode> preOrderTraverse2(TreeNode root){

       List<TreeNode> res = new ArrayList<>();
       if( root == null){

           return res;
       }

       res.add(root);
       res.addAll(preOrderTraverse2(root.left));
       res.addAll(preOrderTraverse2(root.right));

       return res;
    }

    //打印每一个节点所在的层数
    //调用的时候可以这样：getLevel(root, level)
    public void getLevel(TreeNode root,int level){

        if( root == null){

            return;
        }

        System.out.println(root + "节点在第" + level + "层");
        getLevel(root.left,level+1);
        getLevel(root.right,level+1);
    }

    //输入一个二叉树的根节点，然后二叉树的总节点数
    public int count(TreeNode root){

        if( root == null){

            return 0;
        }

        int left = count( root.left);
        int right = count( root.right);

        return left + right + 1;
    }

    //二叉树的层序遍历
    public void levelTraverse(TreeNode root){

        if( root == null){

            return;
        }

        Queue<TreeNode> q = new LinkedList<>();

        //二叉树从上到下
        while( !q.isEmpty()){

            int sz = q.size();
            //二叉树的某一层从左到右
            for(int i = 0; i < sz; i++){

                TreeNode cur = q.poll();
                System.out.println(cur);

                if( cur.left != null){

                    q.offer(cur.left);
                }

                if( cur.right != null){

                    q.offer(cur.right);
                }
            }
        }
    }
}
