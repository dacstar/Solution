package LeetCode;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class AddTwoNumber {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode answer = addTwoNumbers(l1, l2);

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultNode=null;
		ListNode nextNode=null;
		int carry=0;
		while(l1 != null || l2 !=null) {
			int value= (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0)+carry;
			if(value >=10) {
				value=value-10;
				carry=1;
			}
			
			if(resultNode == null) {
				resultNode = new ListNode(value);
				nextNode=resultNode;
			}else {
				nextNode.next=new ListNode(value);
				nextNode =nextNode.next;
			}
			
			
			l1 = (l1 != null ? l1.next : null);
			l2 = (l2 != null ? l2.next : null);
				
			
			
		}
		
		return resultNode;
	}

}
