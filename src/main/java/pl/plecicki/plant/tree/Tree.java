package pl.plecicki.plant.tree;

import pl.plecicki.plant.tree.parts.TreeBranch;
import pl.plecicki.plant.tree.parts.TreeRoot;
import pl.plecicki.plant.tree.parts.TreeTrunk;

import java.util.List;

public class Tree {

    private List<TreeBranch> treeBranches;
    private TreeRoot root;
    private TreeTrunk trunk;

    public List<TreeBranch> getTreeBranches() {
        return treeBranches;
    }

    public void setTreeBranches(List<TreeBranch> treeBranches) {
        this.treeBranches = treeBranches;
    }

    public TreeRoot getRoot() {
        return root;
    }

    public void setRoot(TreeRoot root) {
        this.root = root;
    }

    public TreeTrunk getTrunk() {
        return trunk;
    }

    public void setTrunk(TreeTrunk trunk) {
        this.trunk = trunk;
    }
}
