package zhangjian2.BinaryTree.gouzaopian20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-06-12-11:32
 * @
 **/
public class T106 {

    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i = 0; i < inorder.length; i++){

            valToIndex.put(inorder[i], i);
        }

        return build(postorder,0,postorder.length-1,
                inorder,0, inorder.length-1);
    }

    public TreeNode build(int[] postorder, int postStart, int postEnd,
                          int[] inorder, int inStart, int inEnd){

        if( postStart > postEnd || inStart > inEnd){

            return null;
        }

        //得到根节点的value值
        int rootVal = postorder[ postEnd];

        //得到根节点在inorder中的索引
        int index = valToIndex.get(rootVal);

        //得到根节点的左子树的节点个数
        int leftSize = index - inStart;

        //构造根节点
        TreeNode root = new TreeNode( rootVal);

        //构造根节点的左右子节点
        root.left = build(postorder, postStart, postStart + leftSize - 1,
                inorder, inStart, index-1);
        root.right = build(postorder, postStart + leftSize, postEnd-1,
                inorder, index+1, inEnd);

        return root;
    }
}
