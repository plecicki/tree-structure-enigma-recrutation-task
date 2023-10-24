package pl.plecicki.plant.tree.parts;

import pl.plecicki.exceptions.NotEnoughSunToMeetPassedGrowAmount;
import pl.plecicki.exceptions.NotEnoughWaterToMeetPassedGrowAmount;
import pl.plecicki.exceptions.NotEnoughWaterToPass;
import pl.plecicki.plant.tree.Tree;

public class TreeRoot implements TreePart{

    private int size = 0;
    private int rootSunAmount = 0;
    private int rootWaterAmount = 0;

    public boolean passWaterHigher(int waterAmount, Tree tree) throws NotEnoughWaterToPass {
        if (waterAmount > rootWaterAmount) throw  new NotEnoughWaterToPass();
        tree.getTrunk().addWater(waterAmount);
        rootWaterAmount -= waterAmount;
        return true;
    }

    @Override
    public boolean grow(int growAmount) throws NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount {
        while(growAmount > 0) {
            if (rootWaterAmount == 0) throw new NotEnoughWaterToMeetPassedGrowAmount();
            if (rootSunAmount == 0) throw new NotEnoughSunToMeetPassedGrowAmount();
            size++;
            rootWaterAmount--;
            rootSunAmount--;
            growAmount--;
        }
        return true;
    }

    @Override
    public boolean addWater(int waterAmount) {
        rootWaterAmount += waterAmount;
        return true;
    }

    @Override
    public boolean addSun(int sunAmount) {
        rootSunAmount += sunAmount;
        return true;
    }
}
