package xuejian1.ListNodeDiGui_8;

import org.junit.Test;

/**
 * @author CXWWH
 * @create 2022-05-12-16:12
 * @
 **/
public class T92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if( left == 1){

            return reverseN(head,right);
        }

       head.next = reverseBetween(head.next,left-1,right-1);
        System.out.println("哈哈哈");
        return head;
    }

    ListNode next = null;

    public ListNode reverseN(ListNode node, int n){

        if( n == 1){

            next = node.next;
            return node;
        }

        ListNode last = reverseN(node.next, n - 1);
        node.next.next = node;
        node.next = next;

        return last;
    }

    @Test
    public void test(){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode listNode = reverseBetween(node1,3, 4);

        System.out.println(listNode);
    }
}
