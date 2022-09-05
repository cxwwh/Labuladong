package xuejian1.LinkedList_3;

/**
 * @author CXWWH
 * @create 2022-05-03-15:25
 * @
 **/
public class T876 {

    public ListNode middleNode(ListNode head) {

        ListNode h1 = head;
        ListNode h2 = head;

        while( h1 != null && h1.next != null){

            h1 = h1.next.next;
            h2 = h2.next;
        }

        return h2;
    }
}
