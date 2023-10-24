package pl.plecicki.plant;

import java.time.LocalDate;

public class GeneralPlantData {

    private int age = 0;
    private int hydrationLevel = 0;
    private final LocalDate plantingDate = LocalDate.now();
    private int waterLevel = 0;
    private boolean alive = true;
    private String localisation;

    public GeneralPlantData(String localisation) {
        this.localisation = localisation;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
