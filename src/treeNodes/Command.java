package treeNodes;

/** Общий класс для реализации методов работы с деревьями
 * @author Сергей Шершавин*/

public abstract class Command {
    protected TreeNode root;

    public Command(TreeNode root) {
        this.root = root;
    }

    abstract Object execute();
}
