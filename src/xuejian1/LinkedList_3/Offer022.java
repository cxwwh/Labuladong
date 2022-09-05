package xuejian1.LinkedList_3;

/**
 * @author CXWWH
 * @create 2022-05-03-15:43
 * @
 **/
public class Offer022 {

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while( fast!=null && fast.next!=null){

            fast = fast.next.next;
            slow = slow.next;

            if( slow == fast){
                break;
            }
        }

        if( fast == null || fast.next==null){

            return null;
        }

        slow = head;
        while( slow != fast){

            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
