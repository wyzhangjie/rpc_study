package questions.evrydaystep;

public class SelfTest {
    public boolean isCousins(TreeNode root, int x, int y) {
        Integer[] findX=new Integer[2];
        Integer[] findY=new Integer[2];
        findLevelInfo(root,x,0,findX);
        findLevelInfo(root,y,0,findY);
        if(findX!=null && findY!=null){
            if(findX.length==2 && findY.length==2){
                if(findX[0]==findY[0] && findX[1]!=findY[1]){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCousins2(TreeNode root, int x, int y) {
        Integer[] findX=new Integer[2];
        Integer[] findY=new Integer[2];
        return findLevelInfoV2(root,0,null,x,y,findX,findY);
    }

    private boolean findLevelInfoV2(TreeNode root, int level, TreeNode parent, int x, int y, Integer[] findX, Integer[] findY) {
        if(root==null) return false;
        if(root.val==x){
            findX[0]=level+1;
            if(parent!=null){
                findX[1]=parent.val;
            }

        }
        if(root.val==y){
            findY[0]=level+1;
            if(parent!=null){
                findY[1]=parent.val;
            }

        }
        if(findX[0]==findY[0] && findX[1]!=findY[1]){
            return true;
        }
        return findLevelInfoV2(root.left,level+1,root,x,y,findX,findY) ||findLevelInfoV2(root.right,level+1,root,x,y,findX,findY);

    }


    private void findLevelInfo(TreeNode root, int x, int i,Integer[] lastResult) {
        if(root==null) return;
            if(root.left!=null){
                if(root.left.val==x){
                    lastResult[0]=i+1;
                    lastResult[1]=root.val;
                    return;
                }
                findLevelInfo(root.left,x,i+1,lastResult);
            }
            if(root.right!=null){
                if(root.right.val==x){
                    lastResult[0]=i+1;
                    lastResult[1]=root.val;
                    return;
                }
                findLevelInfo(root.right,x,i+1,lastResult);
            }
    }
    public static void main(String[] args) {
        //[1,2,3,null,4,null,5]
        //5
        //4
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left=node1;
        root.right=node2;
        node1.right=node4;
        node2.right=node5;
        SelfTest leecode993 = new SelfTest();
        System.out.println(leecode993.isCousins2(root,2,3));
    }

}
