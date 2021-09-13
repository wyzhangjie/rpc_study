package questions.evrydaystep;

public class Leecode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
    //找到数字可能所在的行
        int potentialHang=0;
        int lie=matrix[0].length-1;
        if(matrix.length<1){
            return false;
        }
        if(matrix.length==1){

            int left=0;
            int right=lie;
            while (left<=right){
                int mid=left+(right-left)/2;
                if(matrix[0][mid]<target){
                    left=mid+1;
                }else if(matrix[0][mid]==target){
                    return true;
                }else {
                    right=mid-1;
                }
            }

        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][lie]>=target && matrix[i-1][lie]<target){
                potentialHang=i;
            }
        }
        return getResult(matrix,target,potentialHang,lie);
    }

    public boolean getResult(int[][] matrix,int target,int potentialHang,int lie){
        int left=0;
        int right=lie;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(matrix[potentialHang][mid]<target){
                left=mid+1;
            }else if(matrix[potentialHang][mid]==target){
                return true;
            }else {
                right=mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        Leecode74 leecode74 = new Leecode74();
        System.out.println(leecode74.searchMatrix(matrix,34));
    }
}
