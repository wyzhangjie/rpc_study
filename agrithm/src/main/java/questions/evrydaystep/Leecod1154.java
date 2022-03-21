package questions.evrydaystep;

public class Leecod1154 {
    public int dayOfYear(String date) {
        String[] dates = date.split("-");
        Integer year = Integer.valueOf(dates[0]);
        Integer month = Integer.valueOf(dates[1]);
        Integer day = Integer.valueOf(dates[2]);
        int amount[] = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            amount[2] = ++amount[2] ;
        }
        int result = 0;
        for(int i=0;i<month;i++){
            result+=amount[i];
        }
        return result + day;
    }

    public static void main(String[] args) {
        //输入：date = "2019-01-09"
        //输出：9
        Leecod1154 leecod1154 = new Leecod1154();
        System.out.println(leecod1154.dayOfYear("2003-03-01"));
    }
}
