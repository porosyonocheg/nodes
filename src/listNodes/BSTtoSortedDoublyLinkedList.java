package listNodes;

import treeNodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*** Преобразует бинарное дерево поиска в зацикленный отсортированный двусвязный список, где наибольший элемент ссылается
 * на наименьший.
 * @author Сергей Шершавин*/

public class BSTtoSortedDoublyLinkedList {
    public static DoublyLinkedListNode convert(TreeNode root) {
        if (root == null) return null;
        List<Integer> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);
        DoublyLinkedListNode head = new DoublyLinkedListNode(inorder.get(0));
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode prev = head;
        for (int i = 1; i < inorder.size(); i++) {
            current = new DoublyLinkedListNode(inorder.get(i));
            prev.next = current;
            current.previous = prev;
            prev = current;
        }
        current.next = head;
        head.previous = current;
        return head;
    }

    private static void inOrderTraversal(TreeNode node, List<Integer> inorder) {
        if (node == null) return;
        inOrderTraversal(node.left, inorder);
        inorder.add(node.val);
        inOrderTraversal(node.right, inorder);
    }
}
