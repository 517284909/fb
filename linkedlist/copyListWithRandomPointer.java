import java.util.*;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode runner = head;
        while (runner != null) {
            RandomListNode copy = new RandomListNode(runner.label);
            map.put(runner, copy);
            runner = runner.next;
        }

        runner = head;
        while (runner != null) {
            RandomListNode copy = map.get(runner);
            copy.next = map.get(runner.next);
            copy.random = map.get(runner.random);
            runner = runner.next;
        }

        return map.get(head);
    }

    public final static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.copyRandomList(null));

        {
            RandomListNode head = new RandomListNode(1);
            head.next = new RandomListNode(2);
            head.next.next = new RandomListNode(3);
            head.random = head.next.next;
            head.next.random = head;
            RandomListNode new_head = solution.copyRandomList(head);
            while (new_head != null) {
                System.out.println(new_head.label);
                new_head = new_head.next;
            }
        }
    }
}
