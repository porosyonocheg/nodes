package treeNodes;

/**Рекурсивно удаляет все листовые узлы дерева, совпадающие по значению с переданным параметром
 * @author Сергей Шершавин*/

public class DeleteLeavesByValue extends Command {
private final int value;

    public DeleteLeavesByValue(TreeNode root, int value) {
        super(root);
        this.value = value;
    }

    private TreeNode deleteLeavesByValue(TreeNode node) {
        if (node == null) return null;
        node.left = deleteLeavesByValue(node.left);
        node.right = deleteLeavesByValue(node.right);
        return node.left == node.right && node.val == value ? null : node;
    }

    @Override
    public Object execute() {
        return deleteLeavesByValue(root);
    }
}
