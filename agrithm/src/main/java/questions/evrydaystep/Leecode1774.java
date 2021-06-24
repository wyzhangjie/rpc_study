package questions.evrydaystep;
/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 *
 * 你按照如下规则进行一场游戏：
 *
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 *
 * 请你返回得到的数组 answer 。
 * */
public class Leecode1774 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        //1、计算前缀和
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
       for(int i=1;i<candiesCount.length;i++){
           sum[i]=sum[i-1]+candiesCount[i];
       }

       for(int j=0;j<queries.length;j++){
           int favoriteType = queries[j][0];
           int favoriteDay = queries[j][1];
           int dailyCap = queries[j][2];

           long smallX =(long) favoriteDay+1;
           long smallY= (long)(favoriteDay+1)*dailyCap;
           long bigX = (long)favoriteType==0?1:sum[favoriteType-1]+1;
           long bigY = sum[favoriteType];
           result[j]=!(smallX>bigY || smallY<bigX);
       }

return result;

    }


}
