package questions.evrydaystep;

import java.util.Arrays;

/**
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 * <p>
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 * <p>
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 * <p>
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 * <p>
 * 返回在该社交媒体网站上产生的好友请求总数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 * <p>
 * 示例 2：
 * <p>
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 * 示例 3：
 * <p>
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * * age[y] <= 0.5 * age[x] + 7
 * * age[y] > age[x]
 * * age[y] > 100 && age[x] < 100
 * * 否则，x 将会向 y 发送一条好友请求。
 */
public class Leecode825 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int left = 0;
        int right = 0;
        int ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (!checkCanSend(age,ages[left])){
                left++;
            }
            if(right<left){
                right=left+1;
            }
            while (right<ages.length && checkCanSend(age,ages[right])){
                right++;
            }

            ans += right - left-1;
        }
        return ans;

    }

    public  boolean checkCanSend(int x,int y ){
        if(y<=0.5*x+7) return false;
        if (y>x) return false;
        if(y>100 && x<100) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] ages = new int[]{108,115,5,24,82};
        Leecode825 leecode825= new Leecode825();
        System.out.println(leecode825.numFriendRequests(ages));
    }
}
