import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies==null||candies.length==0){
            return null;
        }
        int max=candies[0];
        for (int candy:candies){
            if (candy>max)
                max=candy;
        }
        List<Boolean> result=new ArrayList<Boolean>();
        for (int i=0;i<candies.length;i++){
            result.add(max-candies[i]-extraCandies<=0);
        }
        return result;
    }

}
