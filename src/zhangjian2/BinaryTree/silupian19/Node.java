package zhangjian2.BinaryTree.silupian19;

/**
 * @author CXWWH
 * @create 2022-05-28-21:54
 * @
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
