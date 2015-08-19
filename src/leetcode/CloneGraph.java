package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
 
public class CloneGraph {
	public static void main(String args[]) {
		UndirectedGraphNode node=new UndirectedGraphNode(0);
		node.neighbors.add(new UndirectedGraphNode(1));
		node.neighbors.get(0).neighbors.add(new UndirectedGraphNode(2));
		node.neighbors.get(0).neighbors.get(0).neighbors.add(node.neighbors.get(0).neighbors.get(0));
		cloneGraph(node);
	}
    public static  UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)return null;
        UndirectedGraphNode head=null;
        UndirectedGraphNode retNode=null;
        LinkedList<UndirectedGraphNode> queue=new LinkedList<>();
        queue.add(node);
        HashSet<UndirectedGraphNode>  visited=new HashSet<>();
        int count=0;
        while(!queue.isEmpty()){
        UndirectedGraphNode centerNode=queue.poll();
        head=new UndirectedGraphNode(centerNode.label);
        count++;
        if(count==1){
        retNode=head;
        }
        if(!visited.contains(centerNode)){
            
            for(UndirectedGraphNode neighbor:centerNode.neighbors){
                if(!visited.contains(neighbor)){
                    if(neighbor==centerNode){
                        head.neighbors.add(head);
                    }else{
                        head.neighbors.add(new UndirectedGraphNode(neighbor.label));
                        queue.add(neighbor);
                    }
                }
            }
            visited.add(centerNode);
        }
        
        }
        return retNode;
    }

}
