package leetcode;

import java.util.Stack;

public class longestValidParentheses {

	public static void main(String args[]) {
		longestValidParentheses longestValidParentheses=new longestValidParentheses();
		longestValidParentheses.longestValidParentheses("())");
	}
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if((!stack.empty())&&s.charAt(stack.peek())=='('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }else{
                stack.push(i);
            }
                
        }
        int count=s.length();
        int max=0;
        if(stack.empty())return s.length();
        int tmp1=0;
        while(!stack.empty()){
            tmp1=stack.pop();
            int tmp=count-tmp1;
            if(tmp>max){
                max=tmp;
            }
            count=tmp1;
        }
        if(count-0>max)return count;
        if(max<2)return 0;
        return max;
    }

}
