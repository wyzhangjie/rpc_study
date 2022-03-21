package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Leecode911 {
    int[] persons;

    int[] times;

    public Leecode911(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
    }

    public int q(int t) {
        Map<Integer, Integer> map = new HashMap<>();


        int left = 0;
        int right = times.length;

        if (t > times[times.length - 1]) {
            return findM(times.length - 1);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (times[mid] == t) {
                return findM(mid);
            }

            if (times[mid] < t && mid + 1 < times.length && times[mid + 1] > t) {
                return findM(mid);
            } else if (times[mid] > t && mid - 1 > 0 && times[mid - 1] < t) {
                return findM(mid - 1);
            } else if(times[mid] < t){
                left=mid+1;
            }else {
                right=mid-1;
            }


        }
        return 0;

    }

    private int findM(int pos) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i=0;i<=pos;i++){
            map.put(persons[i],map.getOrDefault(persons[i],0)+1);
        }
        int result=0;
        int time=0;
       for(Integer set:map.keySet()) {
            if(map.get(set)>time){
                result=set;
            }
       }
       return result;
    }

    public static void main (String[]args){
            int[] persons = {0, 1, 1, 0, 0, 1, 0};
            int[] times = {0, 5, 10, 15, 20, 25, 30};
            Leecode911 leecode911 = new Leecode911(persons, times);
            System.out.println(leecode911.q(3));
        }
    }
