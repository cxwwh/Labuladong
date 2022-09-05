package xuejian1.LRU_13;

/**
 * @author CXWWH
 * @create 2022-05-18-21:36
 * @
 **/
public class Node {

    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(){

    }

    public Node(int key, int val){

        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", val=" + val +
                '}';
    }
}
