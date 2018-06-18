/*public class T2 {

    public void levelUpArchitect() {
        if (architect.getLevelUpgrade() == architect.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Building Architect has achieved the highest level.\n");
        } else if ((architect.getLevelUpgrade() < architect.getMaximumUpgradeLevel()) && (architect.getLevelUpgrade() >= architect.getMinimumUpgradeLevel())) {
            architect.addLevelUpgrade(1);
            System.out.println("INFO: Building Architect upgrades about one level. New level amounts " + architect.getLevelUpgrade() + ".\n");
        } else if (architect.getLevelUpgrade() == 0) System.out.println("INFO: Building Architect hasn't existed. At first, you should buy the game.\n");
    }

    //////////////////////////////////////////////////////////////////////////////////



    public void levelUpArchitect() {
        if (architect.getLevelUpgrade() == architect.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Building Architect has achieved the highest level.\n");
        } else if ((architect.getLevelUpgrade() < architect.getMaximumUpgradeLevel()) && (architect.getLevelUpgrade() >= architect.getMinimumUpgradeLevel())) {
            if (enoughMaterials(architect.getCostUpgradeWoodOneLevel(architect.getLevelUpgrade() + 1), architect.getCostUpgradeStoneOneLevel(architect.getLevelUpgrade() + 1))) {
                architect.addLevelUpgrade(1);
                warehouse.removeWood(architect.getCostUpgradeWoodOneLevel(architect.getLevelUpgrade()));
                warehouse.removeStone(architect.getCostUpgradeStoneOneLevel(architect.getLevelUpgrade()));
                System.out.println("INFO: Building Architect upgrades about one level. New level amounts " + architect.getLevelUpgrade() + ".\n");
            } else {
                System.out.println("INFO: W magazynie nie ma wystarczającej ilości materiałów. Potrzeba jeszcze: " + (architect.getCostUpgradeWoodOneLevel(architect.getLevelUpgrade() + 1) - warehouse.getOccupiedSpaceByMaterial(indexOfMaterialWood)) + " jedn. drewna i " + (architect.getCostUpgradeStoneOneLevel(architect.getLevelUpgrade() + 1) - warehouse.getOccupiedSpaceByMaterial(indexOfMaterialStone)) + " jedn. kamienia.\n");
            }
        } else if (architect.getLevelUpgrade() == 0) System.out.println("INFO: Building Architect hasn't existed. At first, you should buy the game.\n");
    }


}*/
