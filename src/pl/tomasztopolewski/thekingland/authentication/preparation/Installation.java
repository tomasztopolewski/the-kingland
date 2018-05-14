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

public abstract class Installation {
    public final static String pathToFolder = "C:\\Program Files\\TheKingLand\\bin\\";
    public final static String nameOfFile_ManagerBuilding = "manager-building";
    public final static String nameOfFile_SpaceOfWarehouse = "materials-space";
    public final static String nameOfDatabase_Players = "players";

    public boolean installation() {
        return false;
    }
}
