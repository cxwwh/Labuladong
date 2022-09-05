package xuejian1.LinkedList_3;

/**
 * @author CXWWH
 * @create 2022-05-03-15:29
 * @
 **/
public class T141 {

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while( fast!=null && fast.next!=null){

            fast = fast.next.next;
            slow = slow.next;

            if( slow == fast){

                return true;
            }
        }

        return false;
    }
}
