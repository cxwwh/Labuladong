package xuejian1.LinkedList_3;

/**
 * @author CXWWH
 * @create 2022-05-02-14:43
 * @
 **/
public class T21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode head = dummy;
        ListNode h1 = list1;
        ListNode h2 = list2;

        while( h1 != null && h2 != null){

            if( h1.val < h2.val){

                head.next = h1;
                h1 = h1.next;
            }else{

                head.next = h2;
                h2 = h2.next;
            }

            head = head.next;
        }

        if( h1 != null){

            head.next = h1;
        }

        if( h2 != null){

            head.next = h2;
        }

        return dummy.next;
    }
}
