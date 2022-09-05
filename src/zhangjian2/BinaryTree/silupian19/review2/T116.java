package zhangjian2.BinaryTree.silupian19.review2;

/**
 * @author CXWWH
 * @create 2022-06-09-21:52
 * @
 **/
public class T116 {

    public Node connect(Node root){

        traverse(root.left,root.right);
        return root;
    }

    public void traverse(Node node1, Node node2){

        if( node1 == null || node2 == null){

            return;
        }

        node1.next = node2;

        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        traverse(node1.right, node2.left);
    }
}
