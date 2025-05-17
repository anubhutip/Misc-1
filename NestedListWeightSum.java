import java.util.List;
import java.util.Queue;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

 /*
class Solution {
    int sum=0;
    public int depthSum(List<NestedInteger> nestedList) {
        int depth=1;
        recurse(nestedList,depth);
        return sum;
    }

    private void recurse(List<NestedInteger> nestedList,int depth){
        //base

        //logic
        for(int i=0;i<nestedList.size();i++){
            if(nestedList.get(i).isInteger()){
                sum=sum+depth*(nestedList.get(i).getInteger());
            }else{
                recurse(nestedList.get(i).getList(),depth+1);
            }
        }
    }
}
*/

/*
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int depth=1;
        return recurse(nestedList,depth);
    }

    private int recurse(List<NestedInteger> nestedList,int depth){

        //logic
        int res=0;
        for(int i=0;i<nestedList.size();i++){
            if(nestedList.get(i).isInteger()){
                res=res+depth*(nestedList.get(i).getInteger());
            }else{
                res=res+recurse(nestedList.get(i).getList(),depth+1);
            }
        }
        return res;
    }
}
*/
//TC: O(n)
//SC: O(n)
class NestedListWeightSum {
    
    public int depthSum(List<NestedInteger> nestedList) {
        int res=0;
        Queue<NestedInteger> que=new LinkedList<>();
        Queue<Integer> qdep=new LinkedList<>();
        for(int i=0;i<nestedList.size();i++){
            que.add(nestedList.get(i));
            qdep.add(1);
        }
        while(!que.isEmpty()){
            NestedInteger curr=que.poll();
            int d=qdep.poll();
            if(curr.isInteger()){
                res=res+d*curr.getInteger();
            }else{
                List<NestedInteger> li = curr.getList();
                for(int i=0;i<li.size();i++){
                    que.add(li.get(i));
                    qdep.add(d+1);
                }
            }
        }
        return res;
    }
}