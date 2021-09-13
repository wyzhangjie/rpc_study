package questions.current.book_1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {
    private final String filename; //保存的文件名称
    private String content; //数据内容
    private  boolean changed; //修改后的内容若未保存，则为 true

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    //修改数据内容
    public  synchronized void change(String newContent) {
        content = newContent;
        changed = true;
        System.out.println(Thread.currentThread().getName() + "calls change , conten=" + content);
    }

    //若数据内容修改过balking 保存到文件中 、、
    public synchronized void save() throws IOException, InterruptedException {
        if (!changed) {
            return;
        }
        doSave();
        Thread.sleep(1000);
        changed = false;
    }

    //将数据 容实际保存到文件中
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + "calls doSave , conten=" + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}