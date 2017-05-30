public class Solution {
    /*题目二叉搜索树的后序遍历序列
    */
    //idea：最后一个数字是根节点的值，数组中前面的数字分为两部分，第一部分为左子树，比根节点的值小；第二部分为右子树，比根节点的值大。
    //time con:O(nlogn), space com:O(1)
    //运行时间：31ms,占用内存：503k
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0)
            return false;
        
        return verify(sequence, 0, sequence.length);
    }
    
    public boolean verify(int[] sequence, int start, int end){
        if(end-start==1) return true;
        int root=sequence[end-1];
        //在二叉搜索树中左子树的结点小于根结点
        int i=start;
        for(; i<end-1; i++){
            if(sequence[i]>root)
                break;
        }
        //在二叉搜索树中右子树的结点大于根结点
        int j=i;
        for(; j<end-1; j++){
            if(sequence[j]<root)
                return false;
        }
		//判断左子树是不是二叉搜索树
        boolean left=true;
        if(i>start)
            left=verify(sequence, start, i);
        //判断右子树是不是二叉搜索树
        boolean right=true;
        if(i<end-1)//存在右子树
            right=verify(sequence, i, j);
        
        return (left & right);
    }
}