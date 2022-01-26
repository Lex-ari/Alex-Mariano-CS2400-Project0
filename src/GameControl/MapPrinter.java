package GameControl;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

public class MapPrinter {

    private static String[][] mapPrint;

    public static void initializeMapPrinter() throws Exception { // this must go after map initialize map.
        mapPrint = new String[Map.getMapHeight()][Map.getMapLength()];
        for (int y = 0; y < Map.getMapHeight(); y++){
            for (int x = 0; x < Map.getMapLength(); x++){
                switch (Map.getTerrainAtCoordinates(y,x).toString()){
                    case "Forest" -> mapPrint[y][x] = "###";
                    case "Grass" -> mapPrint[y][x] = "^^^";
                    case "River" -> mapPrint[y][x] = "-=-";
                    case "Sand" -> mapPrint[y][x] = "...";
                    case "Snow" -> mapPrint[y][x] = "***";
                    case "ChanceSquare" -> mapPrint[y][x] = "$$$";
                    default -> throw new Exception("Terrain is not part of mapPrinter");
                }
            }
        }
    }

    public static void printMap(Brain[] players) throws Exception {
        for (int y = 0; y < Map.getMapHeight(); y++){
            for (int a = 0; a < 3; a++) {
                for (int x = 0; x < Map.getMapLength(); x++) {
                    boolean landPrint = true;
                    for (Brain singlePlayer : players) {
                        if (a == 1 && singlePlayer.getYCood() == y && singlePlayer.getXCood() == x && landPrint) {
                            System.out.print(" ");
                            System.out.print(singlePlayer.getName().substring(0, 1));
                            System.out.print(" ");
                            landPrint = false;
                        }
                    }
                    if (landPrint) {
                        System.out.print(mapPrint[y][x]);
                    }
                    //System.out.print("|");
                }
                System.out.println();
            }
        }
    }

}
