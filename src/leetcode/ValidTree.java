package leetcode;


 
 
public class ValidTree {
	public static void main(String args[]) {
		ValidTree validTree=new ValidTree();
		TreeNode treeNode=new TreeNode(1);
		treeNode.left=new TreeNode(1);
		validTree.isValidBST(treeNode);
	}
    public   boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        
        return isValidTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean isValidTree(TreeNode root,int min,int max){
        if(root==null)return true;
            if(root.val>=max||root.val<=min){
                return false;
            }
        return isValidTree(root.left,min,root.val)&&isValidTree(root.right,root.val,max);
    }
}
