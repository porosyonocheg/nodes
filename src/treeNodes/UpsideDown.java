package treeNodes;

/** Перестраивает дерево, у которого все правые узлы представляют собой листья (или пусты), в дерево, начинающееся с
 * самого нижнего левого листа, его предок становится правым потомком, а его правый "брат" (если существовал)
 * становится левым листом
 * @author Сергей Шершавин*/

public class UpsideDown extends Command {
    private TreeNode newRoot;
    public UpsideDown(TreeNode root) {
        super(root);
        newRoot = null;
    }

    @Override
    public Object execute() {
        upsideDownBinaryTree(root);
        return newRoot;
    }

    private TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left, right = root.right;
        root.left = null;
        root.right = null;
        TreeNode newParent = upsideDownBinaryTree(left);
        if (newRoot == null) {
            newRoot = root;
        }
        else {
            newParent.left = right;
            newParent.right = root;
        }
        return root;
    }
}
