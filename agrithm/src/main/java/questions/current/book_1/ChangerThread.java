package questions.current.book_1;

import java.io.IOException;
import java.util.Random;

public class ChangerThread extends Thread {
    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try {
            for (int i = 0; i<1000; i++) {
                data.change("No."+i);
                Thread.sleep(random.nextInt(1000)); //执行其他操作
                data.save();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
