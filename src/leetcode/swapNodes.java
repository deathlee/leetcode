package leetcode;

class ListNode {
	     int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
public class swapNodes {
	public static void main(String args[]) {
		ListNode node1=new ListNode(1);
		
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		node1.next=node2;
		node2.next=node3;
		swapNodes swapNodes=new swapNodes();
		swapNodes.swapPairs(node1);
	}
    public ListNode swapPairs(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode node=head;
        ListNode result=node.next;
        ListNode node1=node;
        while(node1!=null&&node1.next!=null&&node1.next.next!=null){
            ListNode node2=node1.next;
            ListNode tmp3=node2.next;
            ListNode tmp1=node2.next.next;
            ListNode tmp=node1;
            node1=node2.next;
            node2.next=tmp;
            if(tmp1==null){
            	tmp.next=tmp3;
            }else{
            tmp.next=tmp1;
            }
            
        }
        if(node1==null)return result;
        if(node1.next!=null){
        	
            ListNode tmp=node1.next.next;
            node1.next.next=node1;
            //System.out.println(tmp.next);
            node1.next=tmp;
        }
        return result;
    }

}
