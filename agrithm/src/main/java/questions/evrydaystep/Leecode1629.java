package questions.evrydaystep;

import java.util.*;

public class Leecode1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = 0;
        char key = keysPressed.charAt(0);
        //升序排序
        max = releaseTimes[0];

        for (int i = 1; i < keysPressed.length(); i++) {
            int temp = releaseTimes[i] - releaseTimes[i - 1];
            if (temp > max) {
                max = temp;
                key = keysPressed.charAt(i);
            } else if (temp == max && keysPressed.charAt(i) > key) {
                key = keysPressed.charAt(i);
            }
        }


        return key;
    }

    public static void main(String[] args) {
        int[] releaseTimes = {12, 23, 36, 46, 62};
        String keysPressed = "spuda";
        Leecode1629 leecode1629 = new Leecode1629();
        System.out.println(leecode1629.slowestKey(releaseTimes, keysPressed));
    }
}
