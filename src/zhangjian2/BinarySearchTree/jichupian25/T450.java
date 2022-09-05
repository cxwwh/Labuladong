package zhangjian2.BinarySearchTree.jichupian25;

/**
 * @author CXWWH
 * @create 2022-07-03-9:56
 * @
 **/
public class T450 {

    public TreeNode deleteNode(TreeNode root, int key) {

        if( root == null){

            return null;
        }

        if( root.val == key){

            if( root.left == null){

                return root.right;
            }

            if( root.right == null){

                return root.left;
            }

            //root的左右子树都在
            //获取root的右子树的最小节点
//            TreeNode min = getMin(root.right);
//            //删除root的右子树的最小节点
//            root.right = deleteNode(root.right, min.val);
//            //将root的左右子树挂在min上
//            min.right = root.right;
//            min.left = root.left;
//            root = min;

            //获取root的左子树的最大节点
            TreeNode max = getMax(root.left);
            //在root的左子树中删除这个最大节点，更新root的左子树
            root.left = deleteNode(root.left, max.val);
            max.left = root.left;
            max.right = root.right;
            root = max;

        }else if( root.val < key){

            root.right = deleteNode(root.right,key);
        }else if( root.val > key){

            root.left = deleteNode(root.left,key);
        }

        return root;
    }

    public TreeNode getMin(TreeNode node){

        while( node.left != null){

            node = node.left;
        }

        return node;
    }

    public TreeNode getMax(TreeNode node){

        while( node.right != null){

            node = node.right;
        }

        return node;
    }

}
