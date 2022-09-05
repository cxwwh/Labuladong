package xuejian1.LinkedList_3;

/**
 * @author CXWWH
 * @create 2022-05-03-16:02
 * @
 **/
public class T160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode h1 = headA;
        ListNode h2 = headB;

        while( h1 != h2){

            if( h1 == null){

                h1 = headB;
            }else{

                h1 = h1.next;
            }

            if( h2 == null){

                h2 = headA;
            }else{

                h2 = h2.next;
            }
        }

        return h1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;

        ListNode h1 = headA;
        ListNode h2 = headB;
        while( h1 != null){

            lenA++;
            h1 = h1.next;
        }

        while( h2 != null){

            lenB++;
            h2 = h2.next;
        }

        h1 = headA;
        h2 = headB;

        if( lenA < lenB){

            for(int i = 0; i < (lenB-lenA); i++){

                h2 = h2.next;
            }
        }else if(lenA > lenB){

            for(int i = 0; i < (lenA-lenB); i++){

                h1 = h1.next;
            }
        }

        while( h1 != h2){

            h1 = h1.next;
            h2 = h2.next;
        }

        return h1;
    }
}
