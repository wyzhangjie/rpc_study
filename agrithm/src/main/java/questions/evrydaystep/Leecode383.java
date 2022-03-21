package questions.evrydaystep;

public class Leecode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] data = new int[26];
        for(char a :magazine.toCharArray()){
            data[a-'a']++;
        }
        for(char b:ransomNote.toCharArray()){
            data[b-'a']--;
            if(data[b-'a']<0){
                return false;
            }
        }
        return true;

    }
}
