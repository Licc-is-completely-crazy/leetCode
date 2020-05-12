import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 4);
        List<Integer> list2 = Arrays.asList(1, 3, 4);

        ListNode l1 = new ListNode(list1.get(0));
        ListNode l2 = new ListNode(list2.get(0));

        ListNode tmp1=l1;
        ListNode tmp2=l2;
        for (int i = 1; i < list1.size(); i++) {
            tmp1.next = new ListNode(list1.get(i));
            tmp1 =  tmp1.next;
        }
        tmp1=l1;
        while (tmp1 != null){
            System.out.print(tmp1.val);
            tmp1=tmp1.next;
        }
        System.out.print("\n");
        for (int i = 1; i < list2.size(); i++) {
            tmp2.next = new ListNode(list2.get(i));
            tmp2 = tmp2.next;
        }
        tmp2=l2;

        while (tmp2 != null){
            System.out.print(tmp2.val);
            tmp2=tmp2.next;
        }
        System.out.print("\n");

        ListNode listNode = mergeTwoLists(l1, l2);
        ListNode temp3=listNode;
        while (temp3 != null){
            System.out.print(temp3.val);
            temp3=temp3.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }


        ListNode head=null;
        ListNode tail=null;
        if(l1.val<=l2.val){
            head=l1;
            tail=head;
            l1=l1.next;
        }else{
            head=l2;
            tail=head;
            l2=l2.next;
        }
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                tail.next=l1;
                tail=tail.next;
                l1=l1.next;
            }else if(l2.val<l1.val){
                tail.next=l2;
                tail=tail.next;
                l2=l2.next;
            }
        }
        if(l1==null){
            tail.next=l2;
        }else if(l2==null){
            tail.next=l1;
        }
        return head;
    }

    public static class ListNode {
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
}
