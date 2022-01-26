package TerrainTypes;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

public class ChanceSquare extends Terrain{
    private double foodCost = -3.0;
    private double waterCost = -3.0;
    private double staminaCost = -3.0;

    @Override
    public double getStaminaCost(){
        return staminaCost;
    }
    @Override
    public double getFoodCost(){
        return foodCost;
    }
    @Override
    public double getWaterCost(){
        return waterCost;
    }

    @Override
    public String toString(){
        return "ChanceSquare";
    }


}
