package xuejian1.ArrayShuangZhiZhen_4;

/**
 * @author CXWWH
 * @create 2022-05-05-15:25
 * @
 **/
public class T83 {

    public ListNode deleteDuplicates(ListNode head) {

        if( head == null){

            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while( fast != null){

            if( fast.val != slow.val){

                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }

        slow.next = null;

        return head;
    }
}
