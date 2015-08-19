package leetcode;
class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  };
public class RandomList {
		public static void main(String args[]) {
			RandomList randomList=new RandomList();
			RandomListNode head=new RandomListNode(-1);
			head.next=new RandomListNode(-1);
			randomList.copyRandomList(head);
		}

	    public RandomListNode copyRandomList(RandomListNode head) {
	        if(head==null)return head;
	        RandomListNode node=head;
	        while(node!=null){
	            RandomListNode tmp=node.next;
	            node.next=new RandomListNode(node.label);
	            node.next.next=tmp;
	            node=tmp;
	        }
	        RandomListNode copy=head.next;
	        node=head;
	        while(node!=null){
	            if(node.random!=null){
	                node.next.random=node.random.next;
	            }
	            node=node.next.next;
	        }
	        RandomListNode dummy=new RandomListNode(0);
	        RandomListNode pre=dummy;
	        RandomListNode restore=head;
	        while(restore!=null){
	            RandomListNode tmp=restore.next.next;
	            pre.next=restore.next;
	            pre.next.next=null;
	            restore.next=tmp;
	            restore=tmp;
	            pre=pre.next;
	        }
	        return dummy.next;
	    }

}
