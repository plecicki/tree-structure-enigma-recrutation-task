package pl.plecicki.plant;

import java.time.LocalDate;

public class GeneralPlantData {

    private int age = 0;
    private int hydrationLevel = 0;
    private LocalDate plantingDate = LocalDate.now();
    private int waterLevel = 0;
    private boolean isAlive = true;
    private String localisation;

    public GeneralPlantData() {
    }

    public GeneralPlantData(String localisation) {
        this.localisation = localisation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHydrationLevel() {
        return hydrationLevel;
    }

    public void setHydrationLevel(int hydrationLevel) {
        this.hydrationLevel = hydrationLevel;
    }

    public LocalDate getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(LocalDate plantingDate) {
        this.plantingDate = plantingDate;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
