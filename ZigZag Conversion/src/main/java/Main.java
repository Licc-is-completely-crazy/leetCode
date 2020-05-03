public class Main {
    public static void main(String[] args) {
        String res=convert("PAYPALISHIRING",4);
        System.out.println(res);
    }
    public static String convert(String s, int numRows) {
        //二维数组
        if (numRows==1){
            return s;
        }
        int lenth=s.length();
        int totalCum=getCumLocation(lenth,numRows);
        //实例化二维数组：
        char[][] cc=new char[totalCum][numRows];
        for (int i=0;i<numRows;i++){
            for (int j=0;j<totalCum;j++){
               cc[j][i]='\u0000';
            }
        }
        //初始化
        char[] charArray=s.toCharArray();
        //计算坐标:

        for (int i=1;i<=s.length();i++){
            int row=getRowLocation(i,numRows);
            int cum=getCumLocation(i,numRows);
            System.out.println(cum);
            System.out.println(row);
            cc[cum-1][row-1]=charArray[i-1];
        }
        //以行为主读
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<numRows;i++){
            for (int j=0;j<totalCum;j++){
                if (cc[j][i] != '\u0000')
                    sb.append(cc[j][i]);
            }
        }
        return sb.toString();
    }
    private  static int getCumLocation(int i,int numRows){
        //计算列号
        //一次循环
        int circleCount=numRows*2-2;
        //剩下不够一次循环
        int left=i%circleCount;
        //循环次数
        int time=i/circleCount;
        //循环列
        int cirCum=(numRows-1)*time;
        //剩下元素产生列
        int leftCum=left<=numRows?1:left-numRows+1;
        if (left==0){
            leftCum=0;
        }
        int totalCum=cirCum+leftCum;
        return totalCum;
    }

    private static int getRowLocation(int i,int numRows){
        //计算行号
        int circleCount=numRows*2-2;
        //剩下不够一次循环
        int left=i%circleCount;
        int row=left<numRows?left:numRows*2-left;
        if (left==0){
            return 2;
        }
        return row;
    }

}
