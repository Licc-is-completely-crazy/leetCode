class Solution {
    public int strStr(String haystack, String needle) {
        if(null==needle||needle.length()==0){
            return 0;
        }
        char[] source=haystack.toCharArray();
        char[] compare=needle.toCharArray();
        for(int i=0;i<haystack.length();i++){
            if(source[i]==compare[0]){
                if(macth(source,i,compare)){
                    return i;
                }
            }
        }
        return -1;

    }
    private boolean macth(char[] source,int index,char[] compare){
        if(source.length-index<compare.length){
            return false;
        }
        for(char c:compare){
            if(source[index]!=c){
                return false;
            }
            index++;
        }
        return true;
    }
}