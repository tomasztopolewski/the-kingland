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


}*/
