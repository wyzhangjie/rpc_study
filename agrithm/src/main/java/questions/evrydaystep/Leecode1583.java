package questions.evrydaystep;

public class Leecode1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int unhappy=0;
        int[][] data = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
            data[i][j]=preferences[i][j] ;
            }
        }

        for(int i=0;i<pairs.length;i++){
            int left =pairs[i][0];
            int right = pairs[i][1];
            int[] temp = data[left];
            for(int j=0;j<temp.length;j++){
                if(data[i][j]==right){
                    break;
                }else {
                    int[] rightTemp = data[j];
                    for(int z=0;z<rightTemp.length;z++){
                       /* if()*/
                    }
                }
            }
        }
        return  0;
    }
}
