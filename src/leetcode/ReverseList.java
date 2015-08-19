package leetcode;

public class ReverseList {
	public static void main(String args[]) {
		ReverseList reverseList=new ReverseList();
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		//head.next.next=new ListNode(3);
		//head.next.next.next=new ListNode(4);
		reverseList.reverseList(head);
	}
    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        
        ListNode node=new ListNode(0);
        if(head.next==null){
            node=head;
            return head;
        }
        recursive(head.next,node).next=head;
        head.next=null;
        return node;
    }
    ListNode recursive(ListNode head,ListNode node){
        if(head.next==null){
            node=head;
            return head;
        }
        recursive(head.next,node).next=head;
        return head;
    }

}
