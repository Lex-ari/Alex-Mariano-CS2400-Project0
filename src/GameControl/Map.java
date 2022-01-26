package GameControl;
import TerrainTypes.*;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

public class Map {
    private static Terrain[][] map = new Terrain[10][50];//row, col bc alex is bruh

    // Map is static, bc only one map may exist.

    public static Terrain getTerrainAtCoordinates(int y, int x){ // y and x start at 0 and end with n-1
        return map[y][x];
    }

    public static void initializeMap(){ // fills in random terrain
        for (int y = 0; y < map.length; y++){
            for (int x = 0; x < map[y].length; x++){
                map[y][x] = getRandomTerrain();
            }
        }
    }

    private static Terrain getRandomTerrain(){
        int randomTerrainNumber = (int)(Math.random() * 100);
        Terrain returnTerrain;

        if (randomTerrainNumber > 95){
            return new ChanceSquare();
        }
        if (randomTerrainNumber > 90){
            return new Snow();
        }
        if (randomTerrainNumber > 80){
            return new Sand();
        }
        if (randomTerrainNumber > 60){
            return new River();
        }
        if (randomTerrainNumber > 40){
            return new Forest();
        }
        return new Grass();
    }

    public static int getMapLength(){
        return map[0].length;
    }

    public static int getStartingPosition(){
        return map.length / 2;
    }

    public static int getMapHeight(){
        return map.length;
    }

}
