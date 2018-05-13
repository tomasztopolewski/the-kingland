package pl.tomasztopolewski.thekingland;

public class Map {
    private int x; // gorna dlugosc pola zamku
    private int y; // boczna dlugosc pola zamku
    private int areaSize; // maksymalny rozmiar (x * y)
    private int occupiedArea; // zajety rozmiar zamku

    boolean failedToAddToTheOccupiedArea;


    public Map(int x, int y,  int areaSize, int occupiedArea) {
        this.x = x;
        this.y = y;
        this.areaSize = areaSize;
        this.occupiedArea = occupiedArea;
    } //konstrkutkor
    public Map() {
        this.x = 10;
        this.y = 10;
        this.areaSize = 100;
        this.occupiedArea = 0;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }


    public boolean checkWhetherThereIsFreeSpace(int buildingSize) {
        int expectedOccupiedArea = 0;
        expectedOccupiedArea = buildingSize + occupiedArea;

        if (expectedOccupiedArea > areaSize) {
            return false;
        } else return expectedOccupiedArea <= areaSize;
    }

    public int calcFreeArea() {
        return areaSize - occupiedArea;
    }

    public void enlargeAreaSize(int x, int y) {
        this.x += x;
        this.y += y;
        calcAreaSize();
    }
    public void calcAreaSize() {
        areaSize = x + y;
    }

    public void increaseOccupiedArea(int buildingSize) {
        if (checkWhetherThereIsFreeSpace(buildingSize)) {
            this.occupiedArea += buildingSize;
            failedToAddToTheOccupiedArea = true;
        } else {
            System.out.print("Error: Brak miejsca w zamku.\n");
            failedToAddToTheOccupiedArea = false;
        }
    }
}

// Tomasz Topolewski