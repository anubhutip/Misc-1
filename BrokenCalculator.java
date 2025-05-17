
//BFS
/*
class Solution {
  public int brokenCalc(int startValue, int target) {
      Set<Integer> set=new HashSet<>();
      Queue<Integer> q =new LinkedList<>();
      q.add(startValue);
      set.add(startValue);
      int count=0;
      while(!q.isEmpty()){
          int size=q.size();
          for(int j=0;j<size;j++){
              int curr=q.poll();
              if(curr==target) return count;
              if(curr<target){
                  int baby1=curr*2;
                  if(!set.contains(baby1)){
                      q.add(baby1);
                      set.add(baby1);
                  }
              }
              if(curr>0){
                  int baby2=curr-1;
                  if(!set.contains(baby2)){
                      q.add(baby2);
                      set.add(baby2);
                  }
              }
          }
          count++;
      }
      return count;
  }
}
*/


//DFS
//gives stack overflow
/*
class Solution {
  public int brokenCalc(int startValue, int target) {
      return helper(startValue,target);
  }

  private int helper(int start, int target){
      //base
      if(start==target){
          return 0;
      }

      //logic
      int case1 = Integer.MAX_VALUE;
      if(start<target){
          int baby1=2*start;
          case1=helper(baby1,target);
      }

      int case2 = Integer.MAX_VALUE;
      if(start>0){
          int baby2=start-1;
          case2=helper(baby2,target);
      }

      return Math.min(case1,case2)+1;
  }
}
*/
//Memo
/*
class Solution {
  HashMap<Integer,Integer> map=new HashMap<>();
  public int brokenCalc(int startValue, int target) {
      return helper(startValue,target);
  }

  private int helper(int start, int target){
      //base
      if(start==target){
          return 0;
      }

      //logic
      int case1 = Integer.MAX_VALUE;
      if(start<target){
          int baby1=2*start;
          case1=helper(baby1,target);
      }

      int case2 = Integer.MAX_VALUE;
      if(start>0){
          int baby2=start-1;
          case2=helper(baby2,target);
      }

      return Math.min(case1,case2)+1;
  }
}
*/

//TC: O(logn) 
//SC: O(1)
class BrokenCalculator {
  
  public int brokenCalc(int startValue, int target) {
      int count=0;
      while(target>startValue){
          if(target%2==0){
              target=target/2;
          }else{
              target++;
          }
          count++;
      }
      return count+ startValue-target;
  }
}

