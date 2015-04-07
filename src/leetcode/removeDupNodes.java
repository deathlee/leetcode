package leetcode;

public class removeDupNodes {
public static void main(String args[]) {
	ListNode node1=new ListNode(1);
	
	ListNode node2=new ListNode(1);
	ListNode node3=new ListNode(2);
	ListNode node4=new ListNode(2);
	node1.next=node2;
	node2.next=node3;
	node3.next=node4;
	removeDupNodes removeDupNodes=new removeDupNodes();
	removeDupNodes.deleteDuplicates(node1);
}

public ListNode deleteDuplicates(ListNode head) {
    if(head==null)return head;
    if(head.next==null)return head;
    ListNode newhead=new ListNode(0);
    ListNode tmp=newhead;
    ListNode node=head;
    while(node!=null){
        int count=0;
        while(node!=null&&node.next!=null&&node.next.val==node.val)
        {
            node.next=node.next.next;
            count++;
        }
        if(count==0){
            tmp.next=node;
            tmp=tmp.next;
            
        }
        else{
            tmp.next=node.next;
        }
        node=node.next;
        
    }
    return newhead.next;
}

}