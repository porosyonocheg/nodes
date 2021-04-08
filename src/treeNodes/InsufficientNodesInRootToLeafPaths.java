package treeNodes;

/**Удаляет все "недостаточные" узлы и возвращает обновлённое дерево. "Недостаточным" считается узел, если все пути от
 * корня до листьев, проходящие через этот узел имеют сумму значений узлов строго меньшую limit
 * @author Сергей Шершавин*/

public class InsufficientNodesInRootToLeafPaths extends Command {
    private final int limit;

    /** Конструктор содержит:
     * @param limit заданный предел достаточности пути от корня до листа*/
    public InsufficientNodesInRootToLeafPaths(TreeNode root, int limit) {
        super(root);
        this.limit = limit;
    }

    private TreeNode sufficientSubset(TreeNode node, int limit) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            return node.val < limit ? null : node;
        }
        node.left = sufficientSubset(node.left, limit - node.val);
        node.right = sufficientSubset(node.right, limit - node.val);
        return node.left == node.right ? null : node;
    }

    @Override
    public Object execute() {
        return sufficientSubset(root, limit);
    }
}
