package pl.tomasztopolewski.thekingland.game;

public interface BuildingWithChangingSquare {
    void setSquare(int square);
    void addSquare(int square);
    void removeSquare(int square);
    int getMinmumSquare();
    int getMaximumSquare();

}

// Tomasz Topolewski