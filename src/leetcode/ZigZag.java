package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZag {
	public static void main(String args[]) {
		ZigZag zag=new ZigZag();
		TreeNode root =new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.right.right=new TreeNode(5);
		zag.zigzagLevelOrder(root);
	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null)return result;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        boolean ifOdd=false;
        while(!stack.isEmpty()){
            List<Integer> list=new ArrayList<Integer>();
            List<TreeNode> tmp=new ArrayList<TreeNode>();
            int level=stack.size();
            for(int i=0;i<level;i++){
                TreeNode node=stack.pop();
                tmp.add(node);
                list.add(node.val);
            }
            for(TreeNode node:tmp){
            if(!ifOdd){
                if(node.left!=null){
                stack.push(node.left);
                }
                if(node.right!=null){
                stack.push(node.right);
                }
                }else{
                if(node.right!=null){
                stack.push(node.right);
                }
                if(node.left!=null){
                stack.push(node.left);
                }
                }
            }
            ifOdd=!ifOdd;
            result.add(list);
        }
        return result;
    }

}
