package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

  class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
 
public class mergeList {
	public static void main(String args[]) {
		List<Interval> intervals=new ArrayList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(5, 6));
		merge(intervals);
	}
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list=intervals;
        if(intervals.size()==0)return list;
        if(intervals.size()==1)return list;
      Comparator<Interval> cmp = new Comparator<Interval>() {
      public int compare(Interval o1, Interval o2) {
        return o1.start-o2.start;
      }
      };
      Collections.sort(list, cmp);
      List<Interval> result=new ArrayList<>();
      int start=list.get(0).start;
      int end=list.get(0).end;
      for(int i=1;i<list.size();i++){
          if(end<=list.get(i).end&&end>list.get(i).start){
              result.add(new Interval(start,list.get(i).end));
              if(i!=list.size()-1){
                  start=list.get(i+1).start;
                  end=list.get(i+1).end;
              }
          }else if(end<=list.get(i).start){
              result.add(new Interval(start,end));
              start=list.get(i).start;
              end=list.get(i).end;
          }else{
              continue;
          }
      }
      return result;
    }
    

}
