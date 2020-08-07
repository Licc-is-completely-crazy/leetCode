class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.translateNum(506));
    }
    public int translateNum(int num) {
        char[] in=String.valueOf(num).toCharArray();
        int[] res = new int[in.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < in.length; i++) {
            if (i == 0) {
                res[0] = 1;
                continue;
            }
            String sum=sb.append(in[i-1]).append(in[i]).toString();
            boolean canMerge=Integer.valueOf(sum)<26&&Integer.valueOf(String.valueOf(in[i-1]))!=0;
            sb.setLength(0);
            if (i==1){
                res[1]=canMerge?res[0]+1:res[0];
                continue;
            }
            if (canMerge) {
                res[i]=res[i-1]+res[i-2];
            }else{
                res[i]=res[i-1];
            }

        }
        return res[res.length-1];
    }
}