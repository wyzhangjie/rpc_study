package questions.evrydaystep;

public class Leecode1185 {
    String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public String dayOfTheWeek(int day, int month, int year) {
        int days=0;
        for(int i=1971;i<year;i++){
            if(isLeapYear(i)){
                days+=366;
            }else {
                days+=365;
            }
        }
        for(int i=1;i<  month;i++){
            days+=monthDays[i-1];
            if(i==2 && isLeapYear(year)){
                days++;
            }
        }

        days+=day;
        return  weeks[(days+4)%7];



    }

    boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }


    public String dayOfTheWeek1(int day, int month, int year) {
        int ans = 4;
        for (int i = 1971; i < year; i++) {
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            ans += isLeap ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            ans += monthDays[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) ans++;
        }
        ans += day;
        return weeks[ans % 7];
    }

    public static void main(String[] args) {
        int day = 31, month = 8, year = 2019;
        Leecode1185 leecode1185 = new Leecode1185();
        System.out.println(leecode1185.dayOfTheWeek(day,month,year));
        System.out.println(leecode1185.dayOfTheWeek1(day,month,year));
    }
}
