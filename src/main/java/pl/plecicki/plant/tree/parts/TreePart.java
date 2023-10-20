package pl.plecicki.plant.tree.parts;

import pl.plecicki.exceptions.NotEnoughSunToMeetPassedGrowAmount;
import pl.plecicki.exceptions.NotEnoughWaterToMeetPassedGrowAmount;

public interface TreePart {

    boolean grow(int growAmount) throws NotEnoughWaterToMeetPassedGrowAmount, NotEnoughSunToMeetPassedGrowAmount;
    boolean addWater(int waterAmount);
    boolean addSun(int sunAmount);
}
