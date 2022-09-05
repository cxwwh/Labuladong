package zhangjian2.BinaryTree.xuliehuapian21;

import java.util.LinkedList;

/**
 * @author CXWWH
 * @create 2022-06-27-9:30
 * @
 **/

//T297
public class PreOrder {

    String SEP = ",";
    String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if( root == null){

            return null;
        }

        StringBuilder sb = new StringBuilder();
        serialize(root,sb);

        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {

        if( root == null){

            sb.append( NULL).append( SEP);
            return;
        }

        sb.append( root.val).append( SEP);
        serialize(root.left, sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if( data == null){

            return null;
        }

        LinkedList<String> nodes = new LinkedList<>();
        String[] split = data.split(SEP);
        for(int i = 0; i < split.length; i++){

            nodes.addLast(split[i]);
        }

        return deserialize(nodes);
    }

    public TreeNode deserialize(LinkedList<String> nodes) {

        if( nodes.isEmpty()){

            return null;
        }

        String s = nodes.removeFirst();

        if( NULL.equals( s)){

            return null;
        }

        TreeNode root = new TreeNode( Integer.parseInt(s));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}

