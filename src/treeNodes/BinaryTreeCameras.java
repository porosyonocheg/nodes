package treeNodes;

/** В узлах бинарного дерева размещаются камеры. Каждая камера может следить за узлом, в котором она расположена, за
 * его предком и его левым и правым потомком. Возвращаем минимальное число камер, необходимое для того, чтобы всё дерево
 * было под наблюдением камер.
 * Статусы каждого узла можно обозначить: NOT_COVERED - не под наблюдением, COVERED_WITH_CAMERA - под наблюдением с
 * установленной в нём камерой, COVERED_NO_CAMERA - под наблюдением камеры предка или одного из потомков.
 * Оптимальным решением будет не устанавливать камеры в листья, так как они будут потенциально покрывать меньшее
 * количество узлов. Исходя из этого узлы с нулевыми потомками считаем покрытыми за счёт предка. Если один из потомков
 * не покрыт, устанавливаем камеру в текущем узле, возвращая соответствующий статус. Если хотя бы в одном из потомков
 * уже установлена камера, следовательно статус текущего узла становится "покрытым без камеры".
 * @author Сергей Шершавин*/

public class BinaryTreeCameras extends Command {
    private int cameras;
    private final int NOT_COVERED;
    private final int COVERED_WITH_CAMERA;
    private final int COVERED_NO_CAMERA;

    public BinaryTreeCameras(TreeNode root) {
        super(root);
        NOT_COVERED = 0;
        COVERED_WITH_CAMERA = 1;
        COVERED_NO_CAMERA = 2;
    }

    @Override
    public Object execute() {
        if (root == null) return 0;
        return (countCameras(root) == NOT_COVERED ? 1 : 0) + cameras;
    }

    private int countCameras(TreeNode node) {
        if (node == null) return COVERED_NO_CAMERA;
        int left = countCameras(node.left), right = countCameras(node.right);
        if (left == NOT_COVERED || right == NOT_COVERED) {
            cameras++;
            return COVERED_WITH_CAMERA;
        }
        return left == COVERED_WITH_CAMERA || right == COVERED_WITH_CAMERA ? COVERED_NO_CAMERA : NOT_COVERED;
    }
}
