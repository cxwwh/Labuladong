package xuejian1.LinkedList_3.review;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author CXWWH
 * @create 2022-06-12-8:45
 * @
 **/
public class T23 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode h = dummy;

        Queue<ListNode> q = new PriorityQueue<>((l1,l2)->{

            return l1.val - l2.val;
        });

        for (ListNode list : lists) {

            if( list != null){

                q.offer(list);
            }
        }

        while( !q.isEmpty()){

            ListNode poll = q.poll();
            h.next = poll;
            h = h.next;

            if( poll.next != null){

                q.offer(poll.next);
            }
        }

        return dummy.next;
    }
}
