import java.util.Stack;

public class Solution {
    public ListNode reverseList(ListNode head) {
        //1
//        Stack<ListNode> stack=new Stack();
//        while(head!=null){
//            stack.push(head);
//            head=head.next;
//        }
//        return getNext(stack);

        //2
        ListNode pre=null;
        while (head!=null){
            ListNode next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;

        //3不难受吗
//        public ListNode reverseList(ListNode head){
//            if (head == null || head.next == null) return head;
//            ListNode p = reverseList(head.next);
//            head.next.next = head;
//            head.next = null;
//            return p;
//        }

    }
    private ListNode getNext(Stack<ListNode> stack){
        if(stack.isEmpty()){
            return null;
        }
        ListNode node=stack.pop();
        node.next=getNext(stack);
        return node;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

