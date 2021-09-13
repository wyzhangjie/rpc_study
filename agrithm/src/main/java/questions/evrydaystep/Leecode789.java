package questions.evrydaystep;

public class Leecode789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int manDist=getManHatten(new int[]{0,0},target);

        for(int[] ghost:ghosts){
            int ghostDist = getManHatten(ghost,target);
            if(ghostDist<=manDist){
                return false;
            }
        }
        return true;
    }

    public int getManHatten(int[] begin,int[] target){
        return Math.abs(target[0]-begin[0])+Math.abs(target[1]-begin[1]);
    }

    public static void main(String[] args) {

    }
}
