package zhangjian2.BinaryTree.xuliehuapian21;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CXWWH
 * @create 2022-06-27-10:11
 * @
 **/
public class Level {

    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if( root == null){

            return null;
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer( root);

        while( !q.isEmpty()){

            TreeNode cur = q.poll();

            if( cur == null){

                sb.append(NULL).append(SEP);
                continue;
            }

            sb.append(cur.val).append(SEP);
            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if( data == null){

            return null;
        }

        String[] nodes = data.split(SEP);
        Queue<TreeNode> q = new LinkedList<>();

        if( NULL.equals(nodes[0])){

            return null;
        }

        TreeNode root = new TreeNode( Integer.parseInt(nodes[0]));
        q.offer( root);

        for(int i = 1; i < nodes.length; ){

            TreeNode parent = q.poll();

            String left = nodes[i];
            i++;
            if( !NULL.equals( left)){

                parent.left = new TreeNode( Integer.parseInt(left));
                q.offer( parent.left);
            }else{

                parent.left = null;
            }

            String right = nodes[i];
            i++;
            if( !NULL.equals( right)){

                parent.right = new TreeNode( Integer.parseInt(right));
                q.offer( parent.right);
            }else{

                parent.right = null;
            }
        }

        return root;
    }


}
