import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] result=solution.getLeastNumbers(new int[]{1,3,2},2);
        for (int i:result){
            System.out.println(i);
        }
        solution.method2(new int[]{1,13,41,23,2,1},4);

    }
    public int[] getLeastNumbers(int[] arr, int k) {
        return method1(arr,k);
    }
    //4次最小堆
    //归并排序 
    public int[] method1(int[] arr, int k){
        List<Integer> input=new ArrayList<Integer>();
        for (int i:arr) {
            input.add(i);
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue();
        priorityQueue.addAll(input);
        int[] result=new int[k];
        for (int i=0;i<k;i++){
            result[i]=priorityQueue.poll();
        }
        return result;
    }

    public int[] method2(int[] arr,int k){
        mergeSort(arr,0,arr.length-1,new int[arr.length]);
        for (int i:arr){
            System.out.println(i);
        }
        return null;
    }

    private void mergeSort(int[] source, int begin,int end,int[] copy){
        if (begin<end){
            int mid=(begin+end)/2;
            //分
            mergeSort(source,begin,mid,copy);
            mergeSort(source,mid+1,end,copy);
            //合
            merge(source,begin,mid,end,copy);
        }
    }
    private void merge(int[] source, int begin,int mid,int end,int[] copy){
        for (int i=begin;i<=end;i++){
            copy[i]=source[i];
        }
        int i=begin;
        int j=mid+1;
        int k=begin;

        while (k <=end) {
            if (i <= mid && j <=end) {
                if (copy[i] <=copy[j]){
                    source[k++] = copy[i++];
                } else {
                    source[k++]=copy[j++];
                }
                continue;
            }
            if (i <=mid) {
                source[k++]=copy[i++];
                continue;
            }
            if (j <=end) {
                source[k++]=copy[j++];
                continue;
            }
        }
    }

}