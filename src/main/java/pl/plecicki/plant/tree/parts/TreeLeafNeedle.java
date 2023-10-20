package pl.plecicki.plant.tree.parts;

import pl.plecicki.exceptions.NotEnoughSunToMeetPassedGrowAmount;
import pl.plecicki.exceptions.NotEnoughSunToPass;
import pl.plecicki.exceptions.NotEnoughWaterToMeetPassedGrowAmount;
import pl.plecicki.exceptions.NotEnoughWaterToPass;
import pl.plecicki.plant.tree.Tree;

import java.util.List;

public class TreeLeafNeedle implements TreePart {

    private int size = 0;
    private int leafNeedleWaterAmount = 0;
    private int leafNeedleSunAmount = 0;

    @Override
    public boolean grow(int growAmount) throws NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount {
        while(growAmount > 0) {
            if (leafNeedleWaterAmount == 0) throw new NotEnoughWaterToMeetPassedGrowAmount();
            if (leafNeedleSunAmount == 0) throw new NotEnoughSunToMeetPassedGrowAmount();
            size++;
            leafNeedleWaterAmount--;
            leafNeedleSunAmount--;
            growAmount--;
        }
        return true;
    }

    @Override
    public boolean addWater(int waterAmount) {
        leafNeedleWaterAmount += waterAmount;
        return true;
    }

    @Override
    public boolean addSun(int sunAmount) {
        leafNeedleSunAmount += sunAmount;
        return true;
    }

    public boolean passSunLower(int sunAmount, TreeBranch branch) throws NotEnoughSunToPass {
        if (sunAmount > leafNeedleSunAmount) throw new NotEnoughSunToPass();
        branch.addSun(sunAmount);
        leafNeedleSunAmount -= sunAmount;
        return true;
    }
}
