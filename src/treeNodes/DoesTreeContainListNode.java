package treeNodes;

import listNodes.ListNode;

/**Определяет содержится ли в данном дереве переданный односвязный список. Проверяется содержание и порядок
 * значений в узлах дерева при обходе от корня к листьям.
 * @author Сергей Шершавин*/

public class DoesTreeContainListNode extends Command {
    private final ListNode head;

    /**Конструктор содержит
     * @param head головной узел односвязного списка*/
    public DoesTreeContainListNode(TreeNode root, ListNode head) {
        super(root);
        this.head = head;
    }

    /**Ищем совпадение значений головного узла списка с текущим узлом дерева, если совпадение найдено, рекурсивно
     * проверяем следующий узел списка с левым и правым поддеревом текущего узла дерева.*/
    private boolean isSubPath(ListNode head, TreeNode root) {
        boolean isPath = dfs(head, root);
        if (root != null && !isPath) {
            isPath = isSubPath(head, root.left) || isSubPath(head, root.right);
        }
        return isPath;
    }

    private boolean dfs(ListNode head, TreeNode node) {
        if (node == null && head == null) return true;
        if (node == null) return false;
        if (head == null) return true;
        if (head.val == node.val) {
            return dfs(head.next, node.left) || dfs(head.next, node.right);
        }
        return false;
    }

    @Override
    public Object execute() {
        return isSubPath(head, root);
    }
}
