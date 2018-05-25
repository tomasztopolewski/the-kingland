/**
 * Klasa 'Installation' odpowiada za poprawną instalację aplikacji.
 * Aktualna wersja klasy: v0.1 DEV
 *
 * Wersje klasy:
 *    v1.0 DEV:
 *    - sprawdzanie poprawności instalacji struktury plików aplikacji
 *    - przeprowadzanie instalacji użytkownika (instalacja domyślnego użytkownika Player1)
 *
 *    v2.0 DEV:
 *    - instalacja użytkownika z włąsną nazwą użytkownika
 *      (Rejestr graczy, sprawdzenie poprawności danych gracza, zalogowanie)
 *
 */
package pl.tomasztopolewski.thekingland.authentication.preparation;

import pl.tomasztopolewski.thekingland.handlingdata.ClassLoadDatabase;
import pl.tomasztopolewski.thekingland.handlingdata.ClassLoadFile;

import java.io.File;

public abstract class Installation {
    public final static String pathToFolder = "C:\\TheKingLand\\bin\\";
    public final static String nameOfFile_ManagerBuilding = "manager-building";
    public final static String nameOfFile_SpaceOfWarehouse = "materials-space";
    public final static String nameOfDatabase_Players = "players";

    public final static String enlargementOfFile = new ClassLoadFile().getEnlargement();
    public final static String enlargementOfDatabase = new ClassLoadDatabase().getEnlargement();

    public static boolean installation() {
        return new File(pathToFolder + nameOfFile_ManagerBuilding + enlargementOfFile).canRead()
                && new File(pathToFolder + nameOfFile_ManagerBuilding + enlargementOfFile).canWrite()

                && new File(pathToFolder + nameOfFile_SpaceOfWarehouse + enlargementOfFile).canRead()
                && new File(pathToFolder + nameOfFile_SpaceOfWarehouse + enlargementOfFile).canWrite();
    }
}