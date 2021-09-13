package questions.tree;

public class DisjointSet {
    public int father[];
    public int rank[];
    //江湖纷争尚未开始，各路高手自成一派
    public void init(int n){
        father=new int[n+1];
        for(int i=1;i<=n;i++){
            father[i]=i;
        }
    }
    //江湖纷争，小兵不站，都找老大出面解决

    public int find(int i){
        if(father[i]==i){
            return i;
        }else {
           return find(father[i]);
        }
    }
    //江湖纷争，终归统一，i的门派输了，要讲门派归为j的门派下
    public void merge(int i,int j){
        //i赢了，要找到自己的老大，报告自己的老大，现在你要收一个门派j到我们门派下，收获一帮小弟。
        father[find(i)]=find(j);
    }
    /**
     * 最简单的并查集效率是比较低的
     * 这启发我们：我们应该把简单的树往复杂的树上合并，而不是相反。因为这样合并后，到根节点距离变长的节点个数比较少
     * */

    //升级版本

    public void initVersion2(int n){
        father=new int[n+1];
        rank= new int[n+1];
        for(int i=1;i<=n;i++){
            father[i]=i;
            rank[i]=1;
        }
    }

    public boolean isInsame(int i,int j){
        return find(i)==find(j);
    }

    public void mergeVersion2(int i,int j){
        //i赢了，要找到自己的老大，报告自己的老大，现在你要收一个门派j到我们门派下，收获一帮小弟。
        int x= find(i);
        int y=find(j);
        if(rank[x]<=rank[y]){
            father[x]=y;
        }  else{
            father[y] = x;
        }
        if (rank[x] == rank[y] && x != y)
            rank[y]++;

    }
}
