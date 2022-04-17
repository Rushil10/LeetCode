/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public void inOrder(TreeNode root,List<Integer> start){
        if(root==null){
            return;
        }
        inOrder(root.left,start);
        start.add(root.val);
        inOrder(root.right,start);
    }
    
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> start = new ArrayList<>();
        inOrder(root,start);
        int n = start.size();
        TreeNode node = new TreeNode(0);
        TreeNode first = node;
        for(int i=0;i<n;i++){
            node.right=new TreeNode(start.get(i));
            node=node.right;
        }
        return first.right;
    }
}