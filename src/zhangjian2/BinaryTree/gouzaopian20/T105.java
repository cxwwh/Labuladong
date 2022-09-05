package zhangjian2.BinaryTree.gouzaopian20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-06-12-11:21
 * @
 **/
public class T105 {

    Map<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++){

            valToIndex.put(inorder[i], i);
        }

        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd){

        if( preStart > preEnd || inStart > inEnd){

            return null;
        }
        //得到根节点
        int rootVal = preorder[preStart];
        //得到根节点在inorder中的索引
        int index = valToIndex.get( rootVal);

        //构造root节点
        TreeNode root = new TreeNode( rootVal);

        int leftSize = index - inStart;
        //构造root的左右子节点
        root.left = build(preorder,preStart+1, preStart + leftSize,
                inorder, inStart,index-1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index+1, inEnd);

        return root;
    }
}
