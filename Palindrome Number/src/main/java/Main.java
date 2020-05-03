public class Main {
    public static void main(String[] args) {
        boolean res=isPalindrome(121);
        System.out.println(res);
    }

    public static  boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        if (x==0){
            return true;
        }
        int oldValue=x;
        int newValue=0;
        while (x>0){
            int last=x%10;
            x=x/10;
            newValue=newValue*10+last;
        }
        return newValue==oldValue;
    }
}
