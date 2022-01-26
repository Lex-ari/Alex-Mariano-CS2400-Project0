package PlayerTypes;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

public class NeedsAGallonPerDay extends Player{

    private double waterFactor = 2.0;

    @Override
    public double getWaterFactor(){
        return waterFactor;
    }

    @Override
    public String getPlayerType(){
        return "NeedsAGallonPerDay";
    }
}
