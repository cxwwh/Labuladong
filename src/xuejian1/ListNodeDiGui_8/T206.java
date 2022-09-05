package xuejian1.ListNodeDiGui_8;

import org.junit.Test;

/**
 * @author CXWWH
 * @create 2022-05-12-15:40
 * @
 **/
public class T206 {

    public ListNode reverseList(ListNode head) {

        if( head == null || head.next == null){

            return head;
        }

        ListNode last = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }


    //翻转前n个节点
    ListNode next = null;
    public ListNode reverseList2(ListNode head, int n) {

        if( n == 1){

            next = head.next;
            return head;
        }

        ListNode last = reverseList2(head.next, n - 1);

        head.next.next = head;
        head.next = next;

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

        ListNode listNode = reverseList2(node1, 3);

        System.out.println(listNode);
    }
}
