package Algorithm20241222;

public class Main {

class ListNode {
     int val;
      ListNode next;
     ListNode(int x) {val = x;
         next = null;
     }
}
    public boolean hasCycle(ListNode head) {
        ListNode cur = head;
        if (cur == null) {
            return false;
        }
        do {
            if (cur.val == Integer.MIN_VALUE) {
                return true;
            }
            cur.val = Integer.MIN_VALUE;
            cur = cur.next;
        } while (cur != null);
        return false;
    }
}
