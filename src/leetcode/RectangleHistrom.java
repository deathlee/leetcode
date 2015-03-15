package leetcode;

import java.util.Stack;

public class RectangleHistrom {
	public static void main(String args[]){
		int height[]={4,2,0,3,2,5};
		int result=largestRectangleArea(height);
		System.out.println(result);
	}

    public static int largestRectangleArea(int[] height) {
        if(height.length==0)return 0;
        int area[]=new int[height.length+1];
        int newHei[]=new int[height.length+1];
        area[0]=0;
        for(int i=0;i<height.length;i++){
            newHei[i]=height[i];
        }
        newHei[height.length]=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int max=0;
        for(int i=1;i<height.length+1;i++){
            if(newHei[i]>=newHei[stack.peek()]){
                stack.push(i);
            }
            else{
                int count=i-1;
                while((!stack.empty())&&(newHei[i]<newHei[stack.peek()]))
                {
                    
                    int index=stack.pop();
                    area[index]=newHei[index]*(count-index+1);
                    if(stack.empty())
                    {
                        area[index]=area[index]+newHei[index]*(index);
                    }else{
                    	area[index]=area[index]+newHei[index]*(index-stack.peek()-1);
                    }
                }
                stack.push(i);
            }
        }
        
              
            
        for(int i=0;i<height.length+1;i++){
            if(area[i]>max){
                max=area[i];
            }
            
        }
        return max;
    }

}
