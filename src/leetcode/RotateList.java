package leetcode;
  
public class RotateList {
	public static class ListNode {
	      int val;
	      ListNode next;
	      public ListNode(int x) { val = x; }
	}
	public static void main(String args[]) {
		RotateList rotateList=new RotateList();
		ListNode head =new ListNode(1);
		head.next=new ListNode(2);
		int k=2;
		rotateList.rotateRight(head, k);
	}
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null)return null;
        if(head.next==null)return head;
        if(k==0)return head;
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode fast=head;
        ListNode slow=pre;
        ListNode mark=pre;
        int len=0;
        ListNode node=head;
        while(node!=null){
            node=node.next;
            len++;
        }
        k=k%len;
        if(k==0)return head;
        int step=0;
        while(step<k){
            pre=pre.next;
            fast=fast.next;
            step++;
        }
        while(fast!=null){
            pre=pre.next;
            slow=slow.next;
            fast=fast.next;
        }
        ListNode result=slow.next;
        if(slow!=mark){
        pre.next=head;
        slow.next=null;
            
        }
        return result;
    }

}
