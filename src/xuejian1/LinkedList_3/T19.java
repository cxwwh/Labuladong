package xuejian1.LinkedList_3;

import org.junit.Test;

/**
 * @author CXWWH
 * @create 2022-05-02-15:34
 * @
 **/
public class T19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;

        for(int i = 0; i < n+1; i++){

            p1 = p1.next;
        }

        ListNode p2 = dummy;
        while( p1 != null){

            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return dummy.next;
    }

    //使用递归
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        int len = getLength(head, n);

        if( len == n){

            return head.next;
        }

        return head;
    }

    //计算单链表中节点的个数
    //在计算的时候，使用了递归
    //是走到链表的最后，开始计数
    //当计数到 n+1 时，说明找到了链表的倒数 第n+1 个节点
    //这时就能借助倒数 第n+1 个节点删除倒数 第n 个节点
    //注意：如果n和链表的长度相等，即要删除的是第一个节点
    //这种办法不能成功删除节点
    //因为无法计数到 n+1
    //所以需要单独考虑
    public int getLength(ListNode node, int n){

        if( node == null){

            return 0;
        }

        //递的过程
        int len = getLength(node.next,n) + 1;
        //归的过程
        if( len == n+1){

            node.next = node.next.next;
        }
        return len;
    }

    //扩展：倒序遍历单链表
    public void reversePrint(ListNode node){

        if( node == null){

            return;
        }
        //递的过程
        reversePrint(node.next);
        //从后往前归
        System.out.println(node);
    }

    @Test
    public void test(){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

//        reversePrint(node4);
//        val:4

        reversePrint(node1);
//        val:4
//        val:3
//        val:2
//        val:1

    }
}
