/*public class T1 {

    public void buyQuarry() {
        if (quarry.getLevelUpgrade() == 0) {
            quarry.setLevelUpgrade(1);
            System.out.println("INFO: Building Quarry is bought.\n");
        } else {
            System.out.println("INFO: Building Quarry was bought. Transaction isn't realized.\n");
        }
    }

    //////////////////////////////////////////////////////////////////////////////////

    public void buyHouse() {
        if (house.getLevelUpgrade() == 0) {
            if (enoughMaterials(quarry.getCostUpgradeWoodOneLevel(quarry.getLevelUpgrade() + 1), quarry.getCostUpgradeStoneOneLevel(quarry.getLevelUpgrade() + 1))) {
                house.setLevelUpgrade(1);
                warehouse.removeWood(quarry.getCostUpgradeWoodOneLevel(quarry.getLevelUpgrade()));
                warehouse.removeStone(quarry.getCostUpgradeStoneOneLevel(quarry.getLevelUpgrade()));
            System.out.println("INFO: Building House is bought..\n");
            } else {
                System.out.println("INFO: W magazynie nie ma wystarczającej ilości materiałów. Potrzeba jeszcze: " + (quarry.getCostUpgradeWoodOneLevel(quarry.getLevelUpgrade() + 1) - warehouse.getOccupiedSpaceByMaterial(indexOfMaterialWood)) + " jedn. drewna i " + (warehouse.getCostUpgradeStoneOneLevel(warehouse.getLevelUpgrade() + 1) - warehouse.getOccupiedSpaceByMaterial(indexOfMaterialStone)) + " jedn. kamienia.\n");
            }
        } else {
            System.out.println("INFO: Building House was bought. Transaction isn't realized.\n");
        }
    }

    public void buyQuarry() {
        if (quarry.getLevelUpgrade() == 0) {
            if (enoughMaterials(quarry.getCostUpgradeWoodOneLevel(quarry.getLevelUpgrade() + 1), quarry.getCostUpgradeStoneOneLevel(quarry.getLevelUpgrade() + 1))) {
                quarry.setLevelUpgrade(1);
                warehouse.removeWood(quarry.getCostUpgradeWoodOneLevel(quarry.getLevelUpgrade()));
                warehouse.removeStone(quarry.getCostUpgradeStoneOneLevel(quarry.getLevelUpgrade()));
                System.out.println("INFO: Building Quarry is bought.\n");
            } else {
                System.out.println("INFO: W magazynie nie ma wystarczającej ilości materiałów. Potrzeba jeszcze: " + (quarry.getCostUpgradeWoodOneLevel(quarry.getLevelUpgrade() + 1) - warehouse.getOccupiedSpaceByMaterial(indexOfMaterialWood)) + " jedn. drewna i " + (warehouse.getCostUpgradeStoneOneLevel(warehouse.getLevelUpgrade() + 1) - warehouse.getOccupiedSpaceByMaterial(indexOfMaterialStone)) + " jedn. kamienia.\n");
            }
        } else {
            System.out.println("INFO: Building Quarry was bought. Transaction isn't realized.\n");
        }
    }


}
class T1 {
    public void removeWood(int quantity) {
        this.occupiedSpaceByMaterials[indexOfMaterialWood] -= quantity <= this.occupiedSpaceByMaterials[indexOfMaterialWood] ? quantity : 0;
    }
    public void removeStone(int quantity) {
        this.occupiedSpaceByMaterials[indexOfMaterialStone] -= quantity <= this.occupiedSpaceByMaterials[indexOfMaterialStone] ? quantity: 0;
    }


    public void removeWood(int quantity) {
        if (warehouse.getOccupiedSpaceByMaterial(indexOfMaterialWood) == 0) System.out.println("INFO: Brak drewna w magazynie.\n");
        else {
            if (quantity <= warehouse.getOccupiedSpaceByMaterial(indexOfMaterialWood)) {
                warehouse.removeWood(quantity);
                System.out.println("INFO: Pobrano z magazynu " + quantity + " jedn. drewna.\n");
            } else if (quantity > warehouse.getOccupiedSpaceByMaterial(indexOfMaterialWood)) {
                System.out.println("INFO: Nie pobrano " + quantity + " jedn. drewna. W magazynie brakuje " + (quantity - warehouse.getOccupiedSpaceByMaterial(indexOfMaterialWood)) + " jedn. drewna.\n");
            } else System.out.println("INFO: Drewno nie zostało pobrane z magazynu.\n");
        }
    }
    public void removeStone(int quantity) {
        if (warehouse.getOccupiedSpaceByMaterial(indexOfMaterialStone) == 0) System.out.println("INFO: Brak kamienia w magazynie.\n");
        else {
            if (quantity <= warehouse.getOccupiedSpaceByMaterial(indexOfMaterialStone)) {
                warehouse.removeStone(quantity);
                System.out.println("INFO: Pobrano z magazynu " + quantity + " jedn. kamienia.\n");
            } else if (quantity > warehouse.getOccupiedSpaceByMaterial(indexOfMaterialStone)) {
                System.out.println("INFO: Nie pobrano " + quantity + " jedn. kamienia. W magazynie brakuje " + (quantity - warehouse.getOccupiedSpaceByMaterial(indexOfMaterialStone)) + " jedn. kamienia.\n");
            } else System.out.println("INFO: Kamien nie został pobrany z magazynu.\n");
        }
    }
}*/