package zhangjian2.BinaryTree.gouzaopian20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-06-12-14:55
 * @
 **/
public class T889 {

    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder){

        for(int i = 0; i < postorder.length; i++){

            valToIndex.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length-1,
                postorder, 0, postorder.length-1);

    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] postorder, int postStart, int postEnd){

        if( preStart > preEnd || postStart > postEnd){

            return null;
        }

        if( preEnd == preStart){

            return new TreeNode( preorder[preEnd]);
        }

        //通过前序遍历得到根节点的值
        int rootVal = preorder[preStart];

        //那么前序遍历中根节点值后面的值就为二叉树中root的左子节点的值
        int leftVal = preorder[ preStart + 1];

        //得到leftVal在后序遍历结果中的索引
        int index = valToIndex.get( leftVal);

        //以root为根节点的二叉树的左子树的节点数l.'；。？
        int leftSize = index - postStart + 1;

        //构造根节点
        TreeNode root = new TreeNode( rootVal);

        //构造根节点的左右子树
        root.left = build(preorder, preStart+1, preStart + leftSize,
                postorder, postStart,index);

        root.right = build(preorder, preStart+leftSize + 1, preEnd,
                postorder, index+1,postEnd-1);

        return root;
    }
}
