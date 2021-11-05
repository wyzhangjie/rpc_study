package questions.evrydaystep;

public class Leecode482 {
    public String licenseKeyFormatting(String s, int k) {
        int totalDigitals = 0;
        int totalDash = 0;
        char[] temp = s.toCharArray();

        for (char a : temp) {
            if (a == '-') {
                totalDash++;
            } else {
                totalDigitals++;
            }
        }
        StringBuffer sb = new StringBuffer();
        if(totalDigitals==0){
            return "";
        }
        int group = totalDigitals / k;
        int firstNums = totalDigitals % k;
        if (firstNums != 0 && group == 0) {
            for (char a : temp) {
                if (a != '-') {
                    if (a >= 'a' && a <= 'z') {
                        sb.append(a - ' ');
                    } else {
                        sb.append(a);
                    }
                }
            }

        } else {
            boolean isFirst = true;
            int prov = 0;
            while (true) {

                if (prov >= s.length()) {
                    break;
                }
                if (isFirst) {
                    if (firstNums > 0) {
                        int i=0;
                        while (i < firstNums) {
                            if(temp[prov]!='-'){
                                if (temp[prov] >= 'a' && temp[prov] <= 'z') {
                                    sb.append((char)( temp[prov] - ' '));
                                } else {
                                    sb.append(temp[prov]);
                                }
                             i++;
                            }
                            prov++;
                        }

                        sb.append("-");
                    }
                    isFirst = false;

                } else {
                    for (int i = 0; i < group; i++) {
                        int step =0;
                        while ( prov<s.length() && step<k) {

                            if(temp[prov]!='-' ){
                                if (temp[prov] >= 'a' && temp[prov] <= 'z') {
                                    sb.append((char)( temp[prov] - ' '));
                                } else {
                                    sb.append(temp[prov]);
                                }
                                step++;
                            }
                            prov++;
                        }
                        sb.append("-");

                    }
                }

            }
        }

        while (sb.charAt(sb.length()-1)=='-'){
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        //"---"
        //3
        String S = "---";
        int K = 3;
        Leecode482 leecode482 = new Leecode482();
        System.out.println(leecode482.licenseKeyFormatting(S, K));
    }
}
