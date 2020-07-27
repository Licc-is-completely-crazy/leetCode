import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.lastRemaining(5,3);
    }

    public int lastRemaining(int n, int m) {
        List<Integer> arry=new ArrayList(n);
        String s=new String();
        for (int i=0;i<n;i++){
            arry.add(i);
        }
        int removeIndex=1;
        while (arry.size()>1){
            removeIndex=(removeIndex+m)%arry.size()-1;
            arry.remove(removeIndex);

        }
        return arry.get(0);

    }
    public int lastRemainingList(int n, int m) {
        Node header=new Node();
        Node p=header;
        for(int i=0;i<n;i++){
            Node node=new Node(i);
            p.next=node;
            node.pre=p;
            p=node;
            if(i==n-1){
                p.next=header.next;
                header.next.pre=p;
            }
        }
        Node first=header.next;
        p=first;
        while(p.next!=p){
            for(int j=0;j<m-1;j++){
                p=p.next;
            }
            p.pre.next=p.next;
            p.next.pre=p.pre;
            p=p.next;
        }
        return p.value;
    }
    public static class Node{
        public Integer value;
        public Node pre;
        public Node next;
        public Node(){}
        public Node(int value){
            this.value=value;
        }
    }

    private void see(Node node){
        while (node.next!=node){
            System.out.println(node.value);
            node=node.next;
        }
    }
    public String[] permutation(String s) {
        //回溯？
        List<String[]> res=new ArrayList();
        for(int i=0;i<s.length()-1;i++){
            String current=s.substring(0,i);
            if(i==0){
                res.add(new String[]{current});
                continue;
            }
            String[] preRes=res.get(i-1);
            char[] currents=current.toCharArray();
            char newChar=currents[i];
            List<String> currentRes=new ArrayList();
            for(String p:preRes){
                char[] temArray=p.toCharArray();
                for(int j=0;j<p.length();j++){
                    for(int k=0;k<p.length();k++){
                        StringBuilder sb=new StringBuilder();
                        if(j==k){
                            sb.append(newChar).append(temArray[k]);
                        }
                        sb.append(temArray[k]);
                        if(k==p.length()-1){
                            currentRes.add(sb.toString());
                        }
                    }
                }
            }
            String[] currentArray = currentRes.toArray(new String[currentRes.size()]);
            res.add(currentArray);
        }
        return res.get(s.length()-1);

    }
}