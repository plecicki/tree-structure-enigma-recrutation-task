package pl.plecicki.plant.tree.parts;

import pl.plecicki.exceptions.NotEnoughSunToMeetPassedGrowAmount;
import pl.plecicki.exceptions.NotEnoughSunToPass;
import pl.plecicki.exceptions.NotEnoughWaterToMeetPassedGrowAmount;
import pl.plecicki.exceptions.NotEnoughWaterToPass;
import pl.plecicki.plant.tree.Tree;

import java.util.List;

public class TreeTrunk implements TreePart {

    private int size = 0;
    private int trunkWaterAmount = 0;
    private int trunkSunAmount = 0;

    public boolean passWaterHigher(int waterAmount, Tree tree) throws NotEnoughWaterToPass {

        if (waterAmount > trunkWaterAmount) throw new NotEnoughWaterToPass();
        List<TreeBranch> treeBranches = tree.getBranches();

        //Trochę wody zostanie utracone przez zaokrąglanie całkowitoliczbowe
        //Jest to zabieg zamierzony inicjujący naturalne procesy utraty wody w roślinach
        int waterPerBranch = waterAmount/treeBranches.size();

        for (TreeBranch treeBranch : treeBranches) {
            treeBranch.addWater(waterPerBranch);
        }
        return true;
    }

    public boolean passSunLower(int sunAmount, Tree tree) throws NotEnoughSunToPass {
        if (sunAmount > trunkSunAmount) throw new NotEnoughSunToPass();
        tree.getRoot().addSun(sunAmount);
        trunkSunAmount -= sunAmount;
        return true;
    }

    @Override
    public boolean grow(int growAmount) throws NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount {
        while(growAmount > 0) {
            if (trunkWaterAmount == 0) throw new NotEnoughWaterToMeetPassedGrowAmount();
            if (trunkSunAmount == 0) throw new NotEnoughSunToMeetPassedGrowAmount();
            size++;
            trunkWaterAmount--;
            trunkSunAmount--;
            growAmount--;
        }
        return true;
    }

    @Override
    public boolean addWater(int waterAmount) {
        trunkWaterAmount += waterAmount;
        return true;
    }

    @Override
    public boolean addSun(int sunAmount) {
        trunkSunAmount += sunAmount;
        return true;
    }
}
