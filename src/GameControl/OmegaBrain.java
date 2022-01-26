package GameControl;

import PlayerTypes.Player;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

public class OmegaBrain extends Brain{

    public OmegaBrain(Player player) throws Exception {
        setPlayerType(player);
    }

    @Override
    public String getBrainType(){
        return "OmegaBrain";
    }

    @Override
    public void move() throws Exception {
        double[] trialResults = {trialNE(), trialEN(), trialE(), trialSE(), trialES()};

        double maxVal = -100;
        int maxValPosition = 2; // this is the default,  in case all the paths lead the player to death.
        for (int x = 0; x < trialResults.length; x++){
            if (trialResults[x] > maxVal){
                maxVal = trialResults[x];
                maxValPosition = x;
            }
        }

        switch (maxValPosition){
            case 0:
                travelToTerrain("N");
                travelToTerrain("E");
                break;
            case 1:
                travelToTerrain("E");
                travelToTerrain("N");
                break;
            case 2:
                travelToTerrain("E");
                break;
            case 3:
                travelToTerrain("S");
                travelToTerrain("E");
                break;
            case 4:
                travelToTerrain("E");
                travelToTerrain("S");
                break;
            default:
                throw new Exception("Max Value Position Does Not Match With Any Config");
        }
        //Do an array here, and then act according to position on array.

        //Does the player die on this route?
        //Prioritize balance over most supply?
    }

    /* How the trials work
    Essentially the brain is playing an imaginary player, that will travel to the coordinates in order to get their output
    The brain decides which is the best considering the most positive out of all the values.

     */
    private double trialNE() throws Exception { // be sure to ensure out of bounds exception
        try {
            if (getValueAtTrail(getYCood() + 1, getXCood()) && getValueAtTrail(getYCood() + 1, getXCood()+1)){
                return -100; // The player had already passed this section. No going back!
                // this also happens if the "search" goes out of the map
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood() + 1, getXCood()));
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood() + 1, getXCood() + 1));
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

    private double trialEN() throws Exception { // be sure to ensure out of bounds exception
        try {
            if (getValueAtTrail(getYCood() + 1, getXCood() + 1) && getValueAtTrail(getYCood(), getXCood() + 1)){
                return -100; // The player had already passed this section. No going back!
                // this also happens if the "search" goes out of the map
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood(), getXCood() + 1));
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood() + 1, getXCood() + 1));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){ // These exceptions also handle array out of bounds on both map and trail
            return -100;
        }
    }

    private double trialSE() throws Exception { // be sure to ensure out of bounds exception
        try {
            if (getValueAtTrail(getYCood() - 1, getXCood()) && getValueAtTrail(getYCood() - 1, getXCood() + 1)){
                return -100; // The player had already passed this section. No going back!
                // this also happens if the "search" goes out of the map
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood() - 1, getXCood()));
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood() - 1, getXCood() + 1));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){ // These exceptions also handle array out of bounds on both map and trail
            return -100;
        }
    }
    private double trialES() throws Exception { // be sure to ensure out of bounds exception
        try {
            if (getValueAtTrail(getYCood(), getXCood() + 1) && getValueAtTrail(getYCood() - 1, getXCood() + 1)){
                return -100; // The player had already passed this section. No going back!
                // this also happens if the "search" goes out of the map
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood(), getXCood() + 1));
            imaginaryPlayer.enter(Map.getTerrainAtCoordinates(getYCood() - 1, getXCood() + 1));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){ // These exceptions also handle array out of bounds on both map and trail
            return -100;
        }
    }
}
