package zhangjian2.BinarySearchTree.jichupian25;

/**
 * @author CXWWH
 * @create 2022-07-03-9:43
 * @
 **/
public class T701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if( root == null){

            return new TreeNode( val);
        }

        //当将val插入以root为根节点的子树上时，根据val与root.val的大小关系
        //可以确定将val插入到root的左子树还是右子树
        //如果该子树不为空，问题转化为将val插入以该节点为根节点的子树上
        //如果该子树为空，那么就在此处新建一个以val为值的节点，将其连接到其父节点
        if( root.val < val){

            //更新右子树
            root.right = insertIntoBST(root.right, val);
        }

        if( root.val > val){

            //更新左子树
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
