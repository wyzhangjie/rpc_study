package questions.evrydaystep;

public class Leecode2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if(m*n!=len){
            return new int[0][];
        }
        int i=0;
        int[][] result = new  int[m][n];
        for(int a=0;a<m;a++){
            for(int b=0;b<n;b++){
                result[a][b]=original[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
       int[] original = {1,2,3,4};
       int m = 2,n = 2;
        Leecode2022 leecode2022 = new Leecode2022();
        System.out.println(leecode2022.construct2DArray(original,m,n));
    }
}
