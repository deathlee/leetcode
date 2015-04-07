package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        TreeNode node=root;
        List<Integer> table=new ArrayList<>();
        int sum=0;
        recursiveTree(node,table,sum);
        int max=0;
        for(Integer i:table){
            if(i>max){
                max=i;
            }
        }
        return max;
    }
   void recursiveTree(TreeNode node,List<Integer> table,int sum){
        if(node==null){
            return;
        }
        sum=sum+node.val;
        table.add(sum);
        recursiveTree(node.left,table,sum);
        recursiveTree(node.right,table,sum);
        
    }

}
