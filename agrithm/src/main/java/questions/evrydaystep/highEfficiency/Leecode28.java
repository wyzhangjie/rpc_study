package questions.evrydaystep.highEfficiency;/**
 * ClassName Leecode28
 * Description
 * Create by jie.zhang02
 * Date 2022/3/5 8:19 下午
 */

/**
 * @author jie.zhang
 * @date 2022年03月05日 8:19 下午
 */
public class Leecode28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0 ) {
            return 0;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }
        boolean isExesit = false;
        int index = 0;
        int innerIndex = 0;

        while (index < haystack.length()) {
            int outIndex=index;
            while (outIndex < haystack.length() && haystack.charAt(outIndex) == needle.charAt(innerIndex)) {
                outIndex++;
                innerIndex++;
                if (innerIndex == needle.length()) {
                    isExesit = true;
                    break;

                }
            }
            if(isExesit){
                break;
            }
            index ++;
            innerIndex=0;
        }
        if (isExesit) {
            return index ;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        //"mississippi"
        //"issip"
       String haystack = "mississippi", needle = "issip";
        Leecode28 leecode28 = new Leecode28();
        System.out.println(leecode28.strStr(haystack,needle));
    }
}