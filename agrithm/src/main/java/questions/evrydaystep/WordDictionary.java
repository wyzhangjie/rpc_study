package questions.evrydaystep;
//字典树
//1、构建，构建26个字母的字段数很容易，只要固定每个节点下面的子节点长度为26即可。
//2、添加字符到树当中遵循 该字符所在位子为空就创建，不为空就忽略的原则。
//3、查询有一个.可以代表任意字符所以只能递归去求，具体思路如下：
//3、递归入参是待查询的字符串，初始查询位置0，和TrieNode树的开头位置。
//4、每一次根据位置获取字符串的字符是否是字符。
    //4.1、如果是字符，则该字符位置不为null，并且剩余字符位置也不为null的情况下返回true，其余情况返回fale
    //4.2、如果不是字符是.,则遍历字典树该层所有不为空的位置，这些位置依次获取剩余字符串位置不为空的情况，如果有这种情况则返回true，没有则返回false
public class WordDictionary {
    class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;

    public WordDictionary() {
    root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode p =root;
        for(int i=0;i<word.length();i++){
            if(p.tns[word.charAt(i)-'a']==null){
                p.tns[word.charAt(i)-'a']=new TrieNode();

            }
            p = p.tns[word.charAt(i)-'a'];

        }
        p.end=true;

    }

    public boolean search(String word) {
        TrieNode p =root;
       return df(word,0,p);


    }

    private boolean df(String word, int i, TrieNode p) {
        if(i==word.length()){
            return p.end;
        }
        if(Character.isLetter(word.charAt(i))){
            TrieNode pos = p.tns[word.charAt(i)-'a'];
            if(pos!=null && df(word,i+1,pos)){
                return true;
            }
        }else {
            for(int j=0;j<26;j++){

                if(p.tns[j]!=null && df(word,i+1,p.tns[j])){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String world = "aaa";
        String world1 = "aa";
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord(world);
        wordDictionary.addWord(world1);
        System.out.println(wordDictionary.search(world));

        System.out.println(wordDictionary.search(world1+"."));

    }
}
