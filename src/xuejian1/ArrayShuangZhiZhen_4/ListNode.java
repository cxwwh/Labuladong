package xuejian1.ArrayShuangZhiZhen_4;

/**
 * @author CXWWH
 * @create 2022-05-02-14:44
 * @
 **/
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     @Override
     public String toString() {

          return "val:" + val;
     }
}
