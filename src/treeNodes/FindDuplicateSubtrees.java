package treeNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Возвращает список поддеревьев-дупликатов в бинарном дереве. Дупликаты имеют одинаковую структуру с одинаковыми
 * значениями соответствующих узлов
 * @author Сергей Шершавин*/

public class FindDuplicateSubtrees extends Command {
    private int defaultId;

    public FindDuplicateSubtrees(TreeNode root) {
        super(root);
        defaultId = 1;
    }

    private int findDuplicates(TreeNode node, Map<String,Integer> subtrees, Map<Integer, Integer> ids, List<TreeNode> result) {
        if (node == null) return 0;
        String serial = node.val + "," + findDuplicates(node.left, subtrees, ids, result) + "," + findDuplicates(node.right, subtrees, ids, result);
        int serialId = subtrees.getOrDefault(serial, defaultId);
        if (serialId == defaultId) defaultId++;
        subtrees.put(serial, serialId);
        ids.put(serialId, ids.getOrDefault(serialId, 0) + 1);
        if (ids.get(serialId) == 2) result.add(node);
        return serialId;
    }

    @Override
    public Object execute() {
        List<TreeNode> result = new ArrayList<>();
        findDuplicates(root, new HashMap<>(), new HashMap<>(), result);
        return result;
    }
}
