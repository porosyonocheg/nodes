package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/**Восстанавливает бинарное дерево поиска, в котором одна пара узлов ошибочно была поменяна местами.
 * @author Сергей Шершавин*/

public class RecoverBST extends Command {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode previous = null;

    public RecoverBST(TreeNode root) {
        super(root);
    }

    /**Обходим дерево inOrder, держа в запасе предыдущий узел и сравнивая его с текущим, как если бы мы шли по массиву.
     * Обнаружив нарушение возрастания значений, запоминаем предыдущий узел, как тот который нужно поменять. Если
     * первый узел для обмена найден, второй найдётся очередным нарушением возрастания при дальнейшем обходе дерева*/
    private void recoverBST(TreeNode node) {
        if (node == null) return;
        recoverBST(node.left);

        if (first == null && (previous == null || previous.val >= node.val)) {
            first = previous;
        }

        if (first != null && previous.val >= node.val) {
            second = node;
        }

        previous = node;
        recoverBST(node.right);
    }

    @Override
    public Object execute() {
        recoverBST(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return root;
    }
}