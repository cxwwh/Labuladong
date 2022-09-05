package xuejian1.LinkedList_3.review;

/**
 * @author CXWWH
 * @create 2022-06-12-8:21
 * @
 **/
public class T21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode h = dummy;

        while( list1 != null && list2 != null){

            if( list1.val < list2.val){

                h.next = list1;
                list1 = list1.next;
                h = h.next;
            }else{

                h.next = list2;
                list2 = list2.next;
                h = h.next;
            }
        }

        if( list1 != null){

            h.next = list1;
        }

        if( list2 != null){

            h.next = list2;
        }

        return dummy.next;
    }
}
