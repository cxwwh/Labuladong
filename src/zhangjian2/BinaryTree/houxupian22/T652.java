package zhangjian2.BinaryTree.houxupian22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CXWWH
 * @create 2022-06-28-9:00
 * @
 **/
public class T652 {

    Map<String, Integer> subtrees = new HashMap<>();
    List<TreeNode> dupliacte = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        traverse(root);
        return dupliacte;
    }

    public String traverse(TreeNode root){

        if( root == null){

            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        int count = subtrees.getOrDefault(subTree,0);

        //只有当 subtrees中有且只有一个重复子树时，才添加子树的根节点
        //这样可以防止有大于两个子树重复时，反复添加root节点
        if( count == 1){

            dupliacte.add(root);
        }

        subtrees.put(subTree, subtrees.getOrDefault(subTree, 0)+1);

        return subTree;
    }
}
