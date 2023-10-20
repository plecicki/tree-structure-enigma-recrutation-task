package pl.plecicki.plant.tree;

import pl.plecicki.exceptions.LeafNeedleIndexDoesntExists;
import pl.plecicki.exceptions.*;
import pl.plecicki.plant.GeneralPlantData;
import pl.plecicki.plant.tree.parts.TreeBranch;
import pl.plecicki.plant.tree.parts.TreeRoot;
import pl.plecicki.plant.tree.parts.TreeTrunk;
import pl.plecicki.plant.tree.treetypes.TreeType;

import java.util.List;

public class Tree {

    private TreeType treeType;
    private GeneralPlantData generalPlantData;
    private List<TreeBranch> treeBranches;
    private TreeRoot root;
    private TreeTrunk trunk;

    public Tree() {
    }

    public Tree(TreeType treeType, String localisation,
                List<TreeBranch> treeBranches, TreeRoot root, TreeTrunk trunk) {
        this.treeType = treeType;
        this.generalPlantData = new GeneralPlantData(localisation);
        this.treeBranches = treeBranches;
        this.root = root;
        this.trunk = trunk;
    }

    public boolean passWaterFromRootToTrunk(int waterAmount) throws NotEnoughWaterToPass {
        return root.passWaterHigher(waterAmount, this);
    }

    public boolean passWaterFromTrunkToBranches(int waterAmount) throws NotEnoughWaterToPass {
        return trunk.passWaterHigher(waterAmount, this);
    }

    public boolean passWaterFromBranchToLeafesNeedles(int waterAmount, int branchIndex)
            throws BranchIndexDoesntExists, NotEnoughWaterToPass {
        if (treeBranches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        return treeBranches.get(branchIndex).passWaterHigher(waterAmount, this);
    }

    public boolean passSunFromLeafsNeedleToBranch(int sunAmount, int branchIndex, int leafNeedleIndex)
            throws BranchIndexDoesntExists, LeafNeedleIndexDoesntExists, NotEnoughSunToPass {

        if (treeBranches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        if (treeBranches.get(branchIndex).getTreeLeafesNeedles().size() <= leafNeedleIndex)
            throw new LeafNeedleIndexDoesntExists();

        return treeBranches.get(branchIndex).getTreeLeafesNeedles().get(leafNeedleIndex)
                .passSunLower(sunAmount, treeBranches.get(branchIndex));
    }

    public boolean passSunFromBranchToTrunk(int sunAmount, int branchIndex)
            throws BranchIndexDoesntExists, NotEnoughSunToPass {
        if (treeBranches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        return treeBranches.get(branchIndex).passSunLower(sunAmount, this);
    }

    public boolean passSunFromTrunkToRoot(int sunAmount) throws NotEnoughWaterToPass {
        return trunk.passWaterHigher(sunAmount, this);
    }

    public boolean growLeafNeedle(int growAmount, int branchIndex, int leafNeedleIndex)
            throws BranchIndexDoesntExists, LeafNeedleIndexDoesntExists,
            NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount {

        if (treeBranches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        if (treeBranches.get(branchIndex).getTreeLeafesNeedles().size() <= leafNeedleIndex)
            throw new LeafNeedleIndexDoesntExists();

        return treeBranches.get(branchIndex).getTreeLeafesNeedles().get(leafNeedleIndex).grow(growAmount);
    }

    public boolean growBranch(int growAmount, int branchIndex)
            throws BranchIndexDoesntExists, NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount {
        if (treeBranches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        return treeBranches.get(branchIndex).grow(growAmount);
    }

    public boolean growTrunk(int growAmount)
            throws NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount {
        return trunk.grow(growAmount);
    }

    public boolean growRoot(int growAmount)
            throws NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount {
        return root.grow(growAmount);
    }

    public boolean dropLeafNeedle(int branchIndex, int leafNeedleIndex)
            throws BranchIndexDoesntExists, LeafNeedleIndexDoesntExists {

        if (treeBranches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        if (treeBranches.get(branchIndex).getTreeLeafesNeedles().size() <= leafNeedleIndex)
            throw new LeafNeedleIndexDoesntExists();

        return treeBranches.get(branchIndex).dropLeafNeedle(leafNeedleIndex);
    }

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
