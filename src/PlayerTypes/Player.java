package PlayerTypes;

import TerrainTypes.*;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

public class Player {

    private double foodSupply;
    private double waterSupply;
    private double staminaSupply;
    private double foodFactor = 1.0;
    private double waterFactor = 1.0;
    private double staminaFactor = 1.0;

    public Player(int foodSupply, int waterSupply, int staminaSupply){
        this.foodSupply = foodSupply;
        this.waterSupply = waterSupply;
        this.staminaSupply = staminaSupply;
    }

    public Player(){
        foodSupply = 20;
        waterSupply = 20;
        staminaSupply = 20;
    }

    public String getPlayerType(){
        return "Player";
    }

    public Player(Object playerObject) throws Exception { // copy constructor

        if (playerObject == null || !(super.getClass().isAssignableFrom(playerObject.getClass()))){
            throw new Exception("Object in player copy constructor is not a player or player subclass!");
        }
        this.foodSupply = ((Player) playerObject).getFoodSupply();
        this.foodFactor = ((Player) playerObject).getFoodFactor();
        this.waterSupply = ((Player) playerObject).getWaterSupply();
        this.waterFactor = ((Player) playerObject).getWaterFactor();
        this.staminaSupply = ((Player) playerObject).getStaminaSupply();
        this.staminaFactor = ((Player) playerObject).getStaminaFactor();
    }

    public boolean enter(Terrain terrain){
        double food = terrain.getFoodCost();
        if (food > 0.0) {
            food *= getFoodFactor();
        }
        foodSupply -= food;
        if (foodSupply > 20.0){
            foodSupply = 20.0;
        }
        if (foodSupply < 0.0){
            return false;
        }

        double water = terrain.getWaterCost();
        if (water > 0.0) {
            water *= getWaterFactor();
        }
        waterSupply -= water;
        if (waterSupply > 20.0){
            waterSupply = 20.0;
        }
        if (waterSupply < 0.0){
            return false;
        }

        double stamina = terrain.getStaminaCost();
        if (stamina > 0.0){
            stamina *= getStaminaFactor();
        }
        staminaSupply -= stamina;
        if (staminaSupply > 20.0){
            staminaSupply = 20.0;
        }
        if (staminaSupply < 0.0){
            return false;
        }
        return true;
    }

    public double getFoodSupply(){
        return foodSupply;
    }
    public double getWaterSupply(){
        return waterSupply;
    }
    public double getStaminaSupply(){
        return staminaSupply;
    }

    public void setFoodSupply(int foodSupply){
        this.foodSupply = foodSupply;
    }
    public void setWaterSupply(int waterSupply){
        this.waterSupply = waterSupply;
    }
    public void setStaminaSupply(int staminaSupply){
        this.staminaSupply = staminaSupply;
    }

    public double getFoodFactor(){
        return foodFactor;
    }
    public double getWaterFactor(){
        return waterFactor;
    }
    public double getStaminaFactor(){
        return staminaFactor;
    }

    @Override
    public String toString(){
        return getPlayerType() + "\n Food Supply: " + foodSupply + "\n Water Supply: " + waterSupply + "\n Stamina Supply: " + staminaSupply;
    }
}
