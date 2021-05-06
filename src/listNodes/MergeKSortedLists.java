package listNodes;

/**Объединяет k-отсортированных односвязных списков в один*/

public class MergeKSortedLists {

    public static ListNode mergeLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int length = lists.length;
        while (length != 1) {
            for (int i = 0; i < length/2; i++) {
                lists[i] = MergeTwoSortedLists.mergeTwoLists(lists[i*2], lists[i*2+1]);
            }

            if (length%2 == 1) {
                lists[length/2] = lists[length-1];
            }

            length = (length + 1)/2;
        }
        return lists[0];
    }
}
