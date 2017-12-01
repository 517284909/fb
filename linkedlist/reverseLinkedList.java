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

  public ListNode reverseListII(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }

    ListNode next_head = head.next;
    ListNode ret = reverseListII(next_head);
    next_head.next = head;
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
      ListNode new_head = solution.reverseListII(head);
      while (new_head != null) {
        System.out.print(new_head.val);
        new_head = new_head.next;
      }
    }

  }
}
