
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
class DistributeCoinsInBinaryTree {
    int moves;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return moves;
    }

    // private int helper(TreeNode root){
    //     //base
    //     if(root==null){
    //         return 0;
    //     }
    //     //logic
    //     int extra=root.val-1;
    //     extra=extra+helper(root.left);
    //     extra=extra+helper(root.right);
    //     moves=moves+Math.abs(extra);
    //     return extra;
    // }

    //inorder
    private int helper(TreeNode root){
        //base
        if(root==null){
            return 0;
        }
        //logic
        int extra=0;
        extra=extra+helper(root.left);
        extra=extra+root.val-1;
        extra=extra+helper(root.right);
        moves=moves+Math.abs(extra);
        return extra;
    }
    //preorder will also work
}