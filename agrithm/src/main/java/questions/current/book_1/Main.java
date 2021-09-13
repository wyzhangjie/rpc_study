package questions.current.book_1;

public class Main {
    public static void main(String[] args) {
        Data data= new Data ("data.txt " , "( empty )");
        new ChangerThread ("ChangerThread" , data) . start();
        new ServerThread ("SaverThread", data) . start() ;
}
}
