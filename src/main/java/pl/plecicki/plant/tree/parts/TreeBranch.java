package pl.plecicki.plant.tree.parts;

import pl.plecicki.exceptions.*;
import pl.plecicki.plant.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class TreeBranch implements TreePart {

    private int size = 0;
    private int branchWaterAmount = 0;
    private int branchSunAmount = 0;
    private List<TreeLeafNeedle> treeLeafesNeedles = new LinkedList<>();

    public boolean passWaterHigher(int waterAmount, Tree tree) throws NotEnoughWaterToPass {

        if (waterAmount > branchWaterAmount) throw new NotEnoughWaterToPass();

        //Trochę wody zostanie utracone przez zaokrąglanie całkowitoliczbowe
        //Jest to zabieg zamierzony inicjujący naturalne procesy utraty wody w roślinach
        int waterPerLeafNeedle = waterAmount/treeLeafesNeedles.size();

        for (TreeLeafNeedle treeLeafNeedle : treeLeafesNeedles) {
            treeLeafNeedle.addWater(waterPerLeafNeedle);
        }
        return true;
    }

    public boolean passSunLower(int sunAmount, Tree tree) throws NotEnoughSunToPass {
        if (sunAmount > branchSunAmount) throw new NotEnoughSunToPass();
        tree.getTrunk().addSun(sunAmount);
        branchSunAmount -= sunAmount;
        return true;
    }

    public boolean dropLeafNeedle(int leafIndex) throws LeafNeedleIndexDoesntExists {
        if (leafIndex >= treeLeafesNeedles.size()) throw new LeafNeedleIndexDoesntExists();
        treeLeafesNeedles.remove(leafIndex);
        return true;
    }

    @Override
    public boolean grow(int growAmount) throws NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount {
        while(growAmount > 0) {
            if (branchWaterAmount == 0) throw new NotEnoughWaterToMeetPassedGrowAmount();
            if (branchSunAmount == 0) throw new NotEnoughSunToMeetPassedGrowAmount();
            size++;
            branchWaterAmount--;
            branchSunAmount--;
            growAmount--;
        }
        return true;
    }

    @Override
    public boolean addWater(int waterAmount) {
        branchWaterAmount += waterAmount;
        return true;
    }

    @Override
    public boolean addSun(int sunAmount) {
        branchSunAmount += sunAmount;
        return true;
    }

    public List<TreeLeafNeedle> getTreeLeafesNeedles() {
        return treeLeafesNeedles;
    }
}
