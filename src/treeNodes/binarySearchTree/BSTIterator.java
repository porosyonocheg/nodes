package treeNodes.binarySearchTree;

import treeNodes.TreeNode;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**Итератор по бинарному дереву поиска inOrder. Первый вызов метода next() вернёт наименьшее значение в дереве.
 * @author Сергей Шершавин*/
public class BSTIterator {
    private final Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inOrderToQueue(root);
    }

    private void inOrderToQueue(TreeNode root) {
        if (root == null) return;
        inOrderToQueue(root.left);
        queue.add(root.val);
        inOrderToQueue(root.right);
    }

    /**Возвращает значение следующего узла дерева, если он существует
     * @throws NoSuchElementException если следующего узла не существует*/
    public int next() {
        if (queue.isEmpty()) throw new NoSuchElementException("There are no nodes anymore");
        return queue.poll();
    }

    /**Проверяет существует ли следующий узел в данном дереве*/
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
