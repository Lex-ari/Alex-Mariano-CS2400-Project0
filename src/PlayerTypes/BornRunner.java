package PlayerTypes;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

public class BornRunner extends Player{
    private double staminaFactor = 0.1;
    private double waterFactor = 0.7;

    @Override
    public double getStaminaFactor(){
        return staminaFactor;
    }
    @Override
    public double getWaterFactor(){ return waterFactor; }

    @Override
    public String getPlayerType(){
        return "BornRunner";
    }
}
