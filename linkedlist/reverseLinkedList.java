import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode runner = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = runner;
            runner = head;
            head = tmp;
        }
        return runner;
    }

    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode ret = reverseListRecursion(next);
        next.next = head;
        head.next = null;

        return ret;
    }

    public final static void main(String[] args) {
        Solution solution = new Solution();
        {
            ListNode n3 = new ListNode(3, null);
            ListNode n2 = new ListNode(2, n3);
            ListNode n1 = new ListNode(1, n2);
            ListNode head = new ListNode(0, n1);
            ListNode new_head = solution.reverseList(head);
            while (new_head != null) {
                System.out.print(new_head.val);
                new_head = new_head.next;
            }
        }

        {
            ListNode n3 = new ListNode(3, null);
            ListNode n2 = new ListNode(2, n3);
            ListNode n1 = new ListNode(1, n2);
            ListNode head = new ListNode(0, n1);
            ListNode new_head = solution.reverseListRecursion(head);
            while (new_head != null) {
                System.out.print(new_head.val);
                new_head = new_head.next;
            }
        }
    }
}
