package breadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clone an undirected graph, each node in the graph contains a label and a list of its neighbors
 * how we serialize an undirected graph
 * nodes are labeled uniquely
 * we use # as a separator for each node, and , as a separator for node label and each neighbor of the node
 *
 * Example
 * consider the serialized graph {0,1,2#1,2#2,2}
 * the graph has a total of three nodes, and therefore contains three parts as separated by #
 * first node is labeled as 0, Connect node 0 to both nodes 1 and 2
 * second node is labeled as 1, Connect node 1 to node 2
 * third node is labeled as 2, Connect node 2 to node 2 (itself), thus forming a self-cycle
 * visually, the graph looks like the following
 *    1
 *   / \
 *  /   \
 * 0 --- 2
 *      / \
 *      \_/
 * return a deep copied graph
 */

public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        
        return mapping.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
