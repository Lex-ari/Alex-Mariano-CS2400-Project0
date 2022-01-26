package GameControl;

import PlayerTypes.Player;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

public class ComplexBrain extends Brain{

    public ComplexBrain(Player player) throws Exception {
        setPlayerType(player);
    }

    @Override
    public String getBrainType(){
        return "ComplexBrain";
    }

    @Override
    public void move() throws Exception {
        double[] trialResults = {trialN(), trialE(), trialS()};

        double maxVal = -100;
        int maxValPosition = 2; // this is the default,  in case all the paths lead the player to death.
        for (int x = 0; x < trialResults.length; x++){
            if (trialResults[x] > maxVal){
                maxVal = trialResults[x];
                maxValPosition = x;
            }
        }

        switch (maxValPosition){
            case 0 -> travelToTerrain("N");
            case 1 -> travelToTerrain("E");
            case 2 -> travelToTerrain("S");
            default -> throw new Exception("Max Value Position Does Not Match With Any Config");
        }
        //Do an array here, and then act according to position on array.

        //Does the player die on this route?
        //Prioritize balance over most supply?
    }

    private double trialN() throws Exception { // be sure to ensure out of bounds exception
        try {
            if (getValueAtTrail(getYCood() + 1, getXCood())){
                return -100; // The player had already passed this section. No going back!
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood() + 1, getXCood()));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){ // These exceptions also handle array out of bounds on both map and trail
            return -100;
        }
    }

    private double trialE() throws Exception {
        try {
            if (getValueAtTrail(getYCood(), getXCood() + 1)){
                return -100; // The player had already passed this section. No going back!
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood(), getXCood() + 1));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){
            return -100;
        }
    }

    private double trialS() throws Exception {
        try {
            if (getValueAtTrail(getYCood() - 1, getXCood())){
                return -100; // The player had already passed this section. No going back!
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood() - 1, getXCood()));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){
            return -100;
        }
    }

}
