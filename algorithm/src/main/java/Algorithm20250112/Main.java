package Algorithm20250112;

import java.util.ArrayList;
import java.util.List;

public class Main {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            List<Long> a = new ArrayList<>();
            List<Long> b = new ArrayList<>();
            while(l1 != null){
                a.add((long) l1.val);
                l1 = l1.next;
            }
            while(l2 != null){
                b.add((long) l2.val);
                l2 = l2.next;
            }


            Long avalue = 0L;
            Long bvalue = 0L;
            for(int i = 0; i < a.size(); i++){
                avalue = a.get(i) * (long) Math.pow(10, i) + avalue;
            }
            for(int i = 0; i < b.size(); i++){
                bvalue = b.get(i) * (long)Math.pow(10, i) + bvalue;
            }
            long sum = avalue + bvalue;
            
            String sumString = String.valueOf(sum);
            ListNode head = null;
            for(int i = 0; i < sumString.length(); i++){
                head = new ListNode(sumString.charAt(i) - '0', head);
            }
            return head;
        }

        public ListNode addTwoNumbers_official(ListNode l1, ListNode l2) {
            ListNode head = null, tail = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                int sum = n1 + n2 + carry;
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head;
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Solution solution = main.new Solution();
        // l2 = [9]
        ListNode l1 = main.new ListNode(1);
        //[1,9,9,9,9,9,9,9,9,9]
        ListNode l2 = main.new ListNode(9, main.new ListNode(9, main.new ListNode(9, main.new ListNode(9, main.new ListNode(9, main.new ListNode(9, main.new ListNode(9, main.new ListNode(9, main.new ListNode(9)))))))));
        ListNode result = solution.addTwoNumbers(l1, l2);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
