package selftest;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName JavaAliStanderd
 * Description
 * Create by jie.zhang02
 * Date 2022/1/30 4:13 下午
 */
public class JavaAliStanderd {

    public void get(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        for(String iterm:list){
            System.out.println(iterm);
        }
    }


    public static void main(String[] args) {
        JavaAliStanderd javaAliStanderd = new JavaAliStanderd();
        javaAliStanderd.get();

    }
}
