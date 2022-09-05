package zhangjian2.BinaryTree.ganglingpian18.review;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CXWWH
 * @create 2022-06-06-22:56
 * @
 **/
public class MyTest {

    //把根节点看做第一层，打印每个节点所在的层数
    public void printLevel(TreeNode root){

        traverse(root, 1);
    }

    public void traverse(TreeNode root, int level){

        if( root == null){

            return;
        }

        System.out.println(root + "所在的层数为：" + level);
        traverse(root.left, level+1);
        traverse(root.right, level+1);
    }


    //打印出每个节点的左右子树各有多少节点
    //定义getNodeCount(TreeNode root)返回以root为根节点的左右子树的节点总数
    public int getNodeCount(TreeNode root){

        if( root == null){

            return 0;
        }

        int left = getNodeCount(root.left);
        int right = getNodeCount(root.right);

        System.out.println(root + "节点的左子树的节点数为：" + left + ",右子树的节点数为：" + right);
        return left + right + 1;
    }

    //二叉树的层序遍历
    public void levelReverse(TreeNode root){

        if( root == null){

            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //从上到下遍历二叉树的每一层
        while( !queue.isEmpty()){

            int sz = queue.size();
            //从左到右遍历二叉树每一层的每个节点
            for(int i = 0; i < sz; i++){

                TreeNode cur = queue.poll();

                //把下一层放入队列
                if( cur.left != null){

                    queue.offer(cur.left);
                }

                if( cur.right != null){

                    queue.offer(cur.right);
                }
            }
        }
    }


    //二叉树的直径
    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        maxDepth( root);
        return maxD;
    }

    //定义maxDepth(TreeNode root)方法可以返回以root为根节点的二叉树的左右子树的最大深度
    public int maxDepth(TreeNode root){

        if( root == null){

            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int depth = left + right;
        maxD = Math.max(maxD, depth);

        return Math.max(left,right) + 1;
    }
}
