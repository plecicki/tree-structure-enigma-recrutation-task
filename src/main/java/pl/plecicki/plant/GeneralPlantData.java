package pl.plecicki.plant;

import java.time.LocalDate;

public class GeneralPlantData {

    private int age;
    private int hydrationLevel;
    private LocalDate plantingDate;
    private int waterLevel;
    private boolean isAlive;
    private String localisation;

    public GeneralPlantData() {
    }

    public GeneralPlantData(int age, int hydrationLevel,
                            LocalDate plantingDate, int waterLevel,
                            boolean isAlive, String localisation) {
        this.age = age;
        this.hydrationLevel = hydrationLevel;
        this.plantingDate = plantingDate;
        this.waterLevel = waterLevel;
        this.isAlive = isAlive;
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
