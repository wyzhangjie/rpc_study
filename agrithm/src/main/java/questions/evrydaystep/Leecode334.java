package questions.evrydaystep;

public class Leecode334 {
    public boolean increasingTriplet(int[] nums) {
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=a){
                a=num;
            }else if(num<=b){
                b=num;
            }else {
                return true;
            }
        }
        return false;

    }

    public boolean increasingTriplet1(int[] nums) {
      int[] leftSamll = new int[nums.length];
      int[] rightBig = new int[nums.length];
        leftSamll[0]=nums[0];
        rightBig[nums.length-1]=nums[nums.length-1];
      for(int i=1;i<nums.length;i++){

        if(leftSamll[i-1]>nums[i]){

            leftSamll[i]=nums[i];

        }else {
            leftSamll[i]=leftSamll[i-1];
        }
      }
      for(int j=nums.length-2;j>0;j--){
          if(nums[j]>rightBig[j+1]){
              rightBig[j]=nums[j];
          }else {
              rightBig[j]=rightBig[j+1];
          }

      }

      for(int i=1;i<nums.length-1;i++){
          if(leftSamll[i-1]<nums[i] && rightBig[i+1]>nums[i]){
              return true;
          }
      }
      return false;

    }

    public static void main(String[] args) {
       int[] nums = {1,2,1,2,1,2,1,2,1,2};
        Leecode334 leecode334 = new Leecode334();
        System.out.println(leecode334.increasingTriplet1(nums));
    }
}
