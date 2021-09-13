package questions.evrydaystep;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 * "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leecode68 {
    List<String> result = new LinkedList<>();


    public List<String> fullJustify(String[] words, int maxWidth) {

        int wordCount = 0;
        int count = 0;
        int pos = 0;
        List<String> mid = new LinkedList<>();
        for (String word : words) {
            if (pos + word.length()  < maxWidth) {
                //可以带空格的字符串
                wordCount++;
                count += word.length();
                pos += word.length() + 1;
                mid.add(word);
            } else if (pos + word.length() == maxWidth) {
                //无法带空格的最后一个字符串
                wordCount++;
                count += word.length();
                pos += word.length();
                mid.add(word);
                if (wordCount == 1) {
                    //左面特殊处理
                    dealOneWordLine(mid, count, maxWidth);
                } else {
                    dealBlank(mid, wordCount, count, maxWidth);
                }
                count = 0;
                wordCount = 0;
                pos = 0;
                mid.clear();
            } else {
                if (wordCount == 1) {
                    //左面特殊处理
                    dealOneWordLine(mid, count, maxWidth);
                } else {
                    dealBlank(mid, wordCount, count, maxWidth);
                }
                count = 0;
                wordCount = 0;
                pos = 0;
                mid.clear();
                if (pos + word.length() < maxWidth) {
                    wordCount++;
                    count += word.length();
                    pos+= word.length()+1;
                    mid.add(word);
                } else if (pos + word.length() == maxWidth) {
                    wordCount++;
                    count += word.length();
                    mid.add(word);
                    pos+= word.length();

                }
            }
        }

        //最后一行的处理
        dealLastLine(mid, wordCount, count, maxWidth);

        return result;

    }

    private void dealBlank(List<String> mid, int wordCount, int count, int maxWidth) {
        int difBlanks = maxWidth - count;
        int gap = wordCount - 1;
        int base = difBlanks / gap;
        int left = difBlanks % gap;
        StringBuffer stringBuffer = new StringBuffer();
        int temp = 0;
        int leftTemp = 0;
        int baseCount = 1;
        for (String a : mid) {
            stringBuffer.append(a);
            if (baseCount <= gap) {
                for (int i = 0; i < base; i++) {
                    stringBuffer.append(" ");
                }
                baseCount++;
            }

            if (leftTemp < left) {
                stringBuffer.append(" ");
                leftTemp++;
            }
        }
        result.add(stringBuffer.toString());

    }


    private void dealOneWordLine(List<String> mid, int count, int maxWidth) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mid.get(0));
        while (count < maxWidth) {
            stringBuffer.append(" ");
            count++;
        }
        result.add(stringBuffer.toString());
    }

    private void dealLastLine(List<String> mid, int wordCount, int count, int maxWidth) {
        if(mid.size()<=0){
            return;
        }
        if (wordCount == 1) {
            dealOneWordLine(mid, count, maxWidth);
        } else {
            StringBuffer sb = new StringBuffer();
            for (String a : mid) {
                sb.append(a);
                sb.append(" ");
                count++;
            }
            int totalSize = sb.length();
            int temp = totalSize;
            while (temp<maxWidth){
                sb.append(" ");
                temp++;
            }


            result.add(sb.toString());
        }

    }


    public static void main(String[] args) {
        /**
         ["ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"]
         16

         ["Listen","to    ","speak ","to   a","few.  "]

         ["Listen","to","many,","speak","to","a","few."]
         6
         * */
        String[] words = new String[]{"Listen","to","many,","speak","to","a","few."};
        int maxWidth = 6;
        Leecode68 leecode68 = new Leecode68();

        List<String> result = leecode68.fullJustify(words, maxWidth);

        for (String a : result) {
            System.out.println(a);
        }
    }
}
