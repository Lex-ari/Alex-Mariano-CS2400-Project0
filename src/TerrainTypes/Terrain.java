package TerrainTypes;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

public class Terrain {
    private double foodCost = 1.0;
    private double waterCost = 1.0;
    private double staminaCost = 1.0;

    public double getFoodCost(){
        return foodCost;
    }

    public double getWaterCost(){
        return waterCost;
    }

    public double getStaminaCost(){
        return staminaCost;
    }

    @Override
    public String toString(){
        return "Default Terrain";
    }
}
