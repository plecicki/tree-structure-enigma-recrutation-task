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
    private List<TreeBranch> branches;
    private TreeRoot root;
    private TreeTrunk trunk;


    public Tree(TreeType treeType, String localisation,
                List<TreeBranch> branches, TreeRoot root, TreeTrunk trunk) {
        this.treeType = treeType;
        this.generalPlantData = new GeneralPlantData(localisation);
        this.branches = branches;
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
        if (branches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        return branches.get(branchIndex).passWaterHigher(waterAmount, this);
    }

    public boolean passSunFromLeafsNeedleToBranch(int sunAmount, int branchIndex, int leafNeedleIndex)
            throws BranchIndexDoesntExists, LeafNeedleIndexDoesntExists, NotEnoughSunToPass {

        if (branches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        if (branches.get(branchIndex).getTreeLeafesNeedles().size() <= leafNeedleIndex)
            throw new LeafNeedleIndexDoesntExists();

        return branches.get(branchIndex).getTreeLeafesNeedles().get(leafNeedleIndex)
                .passSunLower(sunAmount, branches.get(branchIndex));
    }

    public boolean passSunFromBranchToTrunk(int sunAmount, int branchIndex)
            throws BranchIndexDoesntExists, NotEnoughSunToPass {
        if (branches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        return branches.get(branchIndex).passSunLower(sunAmount, this);
    }

    public boolean passSunFromTrunkToRoot(int sunAmount) throws NotEnoughWaterToPass {
        return trunk.passWaterHigher(sunAmount, this);
    }

    public boolean growLeafNeedle(int growAmount, int branchIndex, int leafNeedleIndex)
            throws BranchIndexDoesntExists, LeafNeedleIndexDoesntExists,
            NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount {

        if (branches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        if (branches.get(branchIndex).getTreeLeafesNeedles().size() <= leafNeedleIndex)
            throw new LeafNeedleIndexDoesntExists();

        return branches.get(branchIndex).getTreeLeafesNeedles().get(leafNeedleIndex).grow(growAmount);
    }

    public boolean growBranch(int growAmount, int branchIndex)
            throws BranchIndexDoesntExists, NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount {
        if (branches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        return branches.get(branchIndex).grow(growAmount);
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

        if (branches.size() <= branchIndex) throw new BranchIndexDoesntExists();
        if (branches.get(branchIndex).getTreeLeafesNeedles().size() <= leafNeedleIndex)
            throw new LeafNeedleIndexDoesntExists();

        return branches.get(branchIndex).dropLeafNeedle(leafNeedleIndex);
    }

    public boolean cutThisTree() throws TreeHasBeenCutBefore {
        if (!generalPlantData.isAlive()) throw new TreeHasBeenCutBefore();
        generalPlantData.setAlive(false);
        return true;
    }

    public List<TreeBranch> getBranches() {
        return branches;
    }

    public TreeRoot getRoot() {
        return root;
    }

    public TreeTrunk getTrunk() {
        return trunk;
    }
}
