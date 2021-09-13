package questions.evrydaystep;

public class Leecode1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int temp =0;
            for(int j=left;j<=right;j++){
                temp^= arr[j];
            }
            result[i]=temp;
        }
        return result;
    }

    public int[] xorQueries1(int[] arr, int[][] queries) {
        int[] midresult = new int[arr.length+1];
        int[] result = new int[queries.length];
        for(int i=0;i<arr.length;i++){
            midresult[i+1] = midresult[i]^arr[i];
        }

        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];

            result[i]=midresult[left]^midresult[right+1];
        }
        return result;
    }
}
