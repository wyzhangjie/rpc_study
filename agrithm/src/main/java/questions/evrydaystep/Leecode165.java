package questions.evrydaystep;

public class Leecode165 {
    public int compareVersion(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            int left=0;
            int right=0;
            for (;i<m &&version1.charAt(i)!='.';i++){
                left=left*10 +version1.charAt(i)-'0';
            }
            i++;
            for (;j<n &&version2.charAt(j)!='.';j++){
                right=right*10 +version2.charAt(j)-'0';
            }
            j++;
            if (left != right) {
                return left > right ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
      String  version1 = "1.0.1", version2 = "1";
        Leecode165 leecode165 = new Leecode165();
        System.out.println(leecode165.compareVersion(version1,version2));
    }
}
