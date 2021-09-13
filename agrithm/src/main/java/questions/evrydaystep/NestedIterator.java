package questions.evrydaystep;

import questions.evrydaystep.base.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    List<Integer> nestedList;
    Iterator<Integer> cur;
    public NestedIterator(List<NestedInteger> aa) {
        this.nestedList= new ArrayList<>();
        dfs(aa);
        cur=nestedList.iterator();
    }

    private void dfs(List<NestedInteger> aa) {
        for(NestedInteger tt:aa){
            if(tt.isInteger()){
                nestedList.add(tt.getInteger());
            }else {
                dfs(tt.getList());
            }
        }
    }

    @Override
    public Integer next() {
       return cur.next();

    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();

    }
}
