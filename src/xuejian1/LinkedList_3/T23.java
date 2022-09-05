package xuejian1.LinkedList_3;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author CXWWH
 * @create 2022-05-02-15:09
 * @
 **/
public class T23 {

    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;
        if( len == 0){

            return null;
        }else if( len == 1 ){

            return lists[0];
        }

        ListNode dummy = new ListNode();
        ListNode head = dummy;
        Queue<ListNode> queue = new PriorityQueue<>(len, (a,b) ->(a.val - b.val));

        for(int i = 0; i < len; i++){


            if( lists[i] != null){
                queue.add(lists[i]);
            }
        }

        while( !queue.isEmpty()){

            ListNode node = queue.poll();
            head.next = node;
            head = head.next;

            if( node.next != null){

                queue.add( node.next);
            }

        }

        return dummy.next;
    }
}
