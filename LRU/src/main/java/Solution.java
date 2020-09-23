import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    //map存linkedList的引用。
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] operators={{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        System.out.println(solution.LRU(operators,3));
    }


    public int[] LRU (int[][] operators, int k){
        List<Integer> result=new ArrayList();
        TemList list=new TemList(k);
        for(int i=0;i<operators.length;i++){
            int[] input=operators[i];
            if(input[0]==1){
                list.set(input[1],input[2]);
            }else if(input[0]==2){
                result.add(list.get(input[1]));
            }
        }
        // write code here
        int[] arrayRes=new int[result.size()];
        for(int j=0;j<arrayRes.length;j++){
            arrayRes[j]=result.get(j);
        }
        return arrayRes;
    }

    class Node{
        public int key;
        public int value;
        public Node next;
        public Node pre;
    }
    class TemList{
        public HashMap<Integer,Node> map;
        public int lengLimit;
        public int length;
        public Node head;
        public Node tail;

        TemList(int limit){
            this.lengLimit=limit;
        }

        public int get(int key){
            if(map==null){
                return -1;
            }
            if(map.get(key)==null){
                return -1;

            }
            Node node=map.get(key);
            if(node!=head){
                Node pre=node.pre;
                Node next=node.next;

                node.next=head;
                node.pre=null;
                head.pre=node;
                head=node;

                pre.next=next;
                if (next!=null){
                    next.pre=pre;
                }else
                {
                    tail=pre;
                }

            }
            return node.value;
        }
        public void set(int key,int value){
            if(map==null){
                map=new HashMap();
            }
            Node node=null;
            if(map.get(key)!=null){
                node=map.get(key);
                node.value=value;

                Node pre=node.pre;
                Node next=node.next;


                node.next=head;
                node.pre=null;
                head.pre=node;
                head=node;
                pre.next=next;

                if (next!=null){
                    next.pre=pre;
                }else {
                    tail=pre;
                }
            }else{
                node=new Node();
                node.value=value;
                node.key=key;
                map.put(key,node);
                if(head==null){
                    head=node;
                    tail=node;
                }else{
                    node.pre=null;
                    node.next=head;
                    head.pre=node;
                    head=node;
                }
                if(lengLimit<++length){
                    Node pre=tail.pre;
                    map.remove(tail.key);
                    tail=pre;
                    pre.next=null;
                }
            }
        }
    }
}