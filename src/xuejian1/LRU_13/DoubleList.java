package xuejian1.LRU_13;

/**
 * @author CXWWH
 * @create 2022-05-18-21:42
 * @
 **/
public class DoubleList {

    private Node head;
    private Node tail;
    private int size;

    //初始化双向链表
    public DoubleList() {

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //从尾部添加新节点
    public void addLast(Node node){

        node.next = tail;
        node.prev = tail.prev;

        tail.prev.next = node;
        tail.prev = node;

        size++;
    }

    //删除链表中的一个节点
    public void remove(Node node){

        node.next.prev = node.prev;
        node.prev.next = node.next;

        size--;
    }

    //删除链表的第一个节点，并返回该节点
    public Node removeFirst(){

        if( head.next == tail){

            return null;
        }

        Node first = head.next;
        remove(first);

        return first;
    }

    //返回链表的大小
    public int getSize(){

        return size;
    }
}
