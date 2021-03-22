package treeNodes;

/** Добавляет в дерево новый ряд узлов на заданной глубине (если она не превышает максимальную глубину дерева).
 * Корень дерева располагается на глубине 1. В случае добавления нового узла на этой глубине исходное дерево будет
 * добавлено в качестве левого поддерева. В общем случае узлы, бывшие левыми поддеревьями, станут левыми поддеревьями
 * нового узла, а бывшие правыми - правыми поддеревьями нового узла.
 * @author Сергей Шершавин*/
public class AddNewRow extends Command {
    private final int val;
    private final int depth;

    public AddNewRow(TreeNode root, int val, int depth) {
        super(root);
        this.val = val;
        this.depth = depth;
    }

    private void addRow(TreeNode node, int currentDepth) {
        if (node == null) return;
        currentDepth++;
        if (depth == currentDepth) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
            return;
        }

        addRow(node.left, currentDepth);
        addRow(node.right, currentDepth);

    }

    @Override
    public Object execute() {
        if (depth == 1) return new TreeNode(val, root, null);
        addRow(root, 1);
        return root;
    }
}
