public class Soultion {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int nextAdd=0;
        ListNode result=new ListNode(-1);
        ListNode res=result;
        while(l1!=null){
            if(l2!=null){
                int sum=l1.val+l2.val+nextAdd;
                int left=sum%10;
                nextAdd=sum/10;
                res.next=new ListNode(left);
                res=res.next;
                l2=l2.next;
                l1=l1.next;
                continue;
            }
            if (nextAdd>0){
                int sum=l1.val+nextAdd;
                int left=sum%10;
                nextAdd=sum/10;
                res.next=new ListNode(left);
            }else {
                res.next=new ListNode(l1.val);
            }
            res=res.next;
            l1=l1.next;
        }
        while(l2!=null){
            if (nextAdd>0){
                int sum=l2.val+nextAdd;
                int left=sum%10;
                nextAdd=sum/10;
                res.next=new ListNode(left);
            }else {
                res.next=new ListNode(l2.val);
            }
            res=res.next;
            l2=l2.next;
        }
        if (nextAdd>0){
            res.next=new ListNode(nextAdd);
            res=res.next;
        }
        return result.next;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
