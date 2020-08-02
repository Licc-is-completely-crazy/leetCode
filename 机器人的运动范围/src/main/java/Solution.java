import java.awt.*;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    Set<Location> result=new HashSet<>();

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.movingCount(2,3,1));
    }


    public int movingCount(int m, int n, int k) {
        moveTo(0,0,k,m,n);
        return result.size();
    }
//    1.怎么计算k
//    2.怎么去重
//    3.怎么移动？
//            3.每个点有4种选择

    private void moveTo(int x,int y,int k,int m,int n){
        Location now=new Location(x,y);
        if (result.contains(now)){
            return;
        }
        result.add(now);
        //上
        if(y-1>=0&&countK(x,y-1)<=k){

            moveTo(x,y-1,k,m,n);
        }
        //下
        if(y+1<=n-1&&countK(x,y+1)<=k){
            moveTo(x,y+1,k,m,n);
        }
        //左
        if(x-1>=0&&countK(x-1,y)<=k){
            moveTo(x-1,y,k,m,n);
        }
        if(x+1<=m-1&&countK(x+1,y)<=k){
            moveTo(x+1,y,k,m,n);
        }
    }

    public int countK(int x,int y){
        int result=0;
        char[] array=(String.valueOf(x)+String.valueOf(y)).toCharArray();
        for (char c:array){
            result=result+Integer.valueOf(c+"");
        }
        return result;
    }

    public static class Location{
        public int x;
        public int y;
        Location(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x &&
                    y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}