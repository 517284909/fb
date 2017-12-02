import java.util.*;

class UndirectedGraphNode {
    int val;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        val = x;
        neighbors = new ArrayList<>();
    }
}

class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
                                           Map<UndirectedGraphNode, UndirectedGraphNode> map) {

        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }

        UndirectedGraphNode node_cp = new UndirectedGraphNode(node.val);
        map.put(node, node_cp);
        for (UndirectedGraphNode n: node.neighbors) {
            node_cp.neighbors.add(cloneGraph(n, map));
        }

        return node_cp;
    }

    public UndirectedGraphNode cloneGraphIteration(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Stack<UndirectedGraphNode> stack = new Stack<>();
        if (node != null) {
            map.put(node, new UndirectedGraphNode(node.val));
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            UndirectedGraphNode top = stack.pop();
            UndirectedGraphNode cp = map.get(top);
            for (UndirectedGraphNode n: top.neighbors) {
                if (!map.containsKey(n)) {
                    UndirectedGraphNode m = new UndirectedGraphNode(n.val);
                    map.put(n, m);
                    stack.push(n);
                }
                cp.neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }
}
