package listNodes;

import treeNodes.TreeNode;
import treeNodes.binarySearchTree.ConvertSortedArrayToBST;

/**Возвращает бинарное дерево поиска, построенное на основе отсортированного списка, используя метод построения BST
 * из отсортированного массива.
 * @author Сергей Шершавин*/
public class ConvertSortedListNodeToBST {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int length = 0;
        ListNode current = head;
        while (current != null){
            current = current.next;
            length++;
        }
        int[] nums = new int[length];
        int i = 0;
        while (head != null) {
            nums[i] = head.val;
            i++;
            head = head.next;
        }
        return (TreeNode) new ConvertSortedArrayToBST(nums).execute();
    }
}
