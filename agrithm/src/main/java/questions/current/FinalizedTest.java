package questions.current;

//入口函数
public class FinalizedTest {
    public static void main(String[] args) {
        final FinalizedTest finalizedTest = new FinalizedTest();
        for (int i = 0; i < 8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        TFutureTask future = finalizedTest.submit();
                    }
                }
            }).start();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.gc();
                }
            }
        }).start();
    }
    public TFutureTask submit(){
        TExecutorService TExecutorService = Executors.create();
        TExecutorService.execute();
        return null;
    }
}


