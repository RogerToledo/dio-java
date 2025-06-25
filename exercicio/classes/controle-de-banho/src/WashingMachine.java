import java.util.Scanner;

public class WashingMachine {
    private int waterTankLevel;
    private int shampooTankLevel;
    private Pet insideWashMachine;
    private static final int MAX_WATER_TANK = 30;
    private static final int MAX_SHAMPOO_TANK = 10;
    private static final int WATER_PER_WASH = 10;
    private static final int SHAMPOO_PER_WASH = 2;
    private static final int MAX_PET = 1;

    public WashingMachine() {
        this.waterTankLevel = MAX_WATER_TANK;
        this.shampooTankLevel = MAX_SHAMPOO_TANK;
    }

    public int getWaterTankLevel() {
        return waterTankLevel;
    }

    private void setWaterTankLevel(int waterTankLevel) {
        this.waterTankLevel = waterTankLevel;
    }

    public int getShampooTankLevel() {
        return shampooTankLevel;
    }

    private void setShampooTankLevel(int shampooTankLevel) {
        this.shampooTankLevel = shampooTankLevel;
    }

    public Pet getInsideWashMachine() {
        return insideWashMachine;
    }

    private void setInsideWashMachine(Pet pet) {
        this.insideWashMachine = pet;
    }

    public void fillWaterTank(int amount) {
        if (waterTankLevel + amount <= MAX_WATER_TANK) {
            waterTankLevel += amount;
        } else {
            System.out.println("Reservatório de água está cheio");
        }
    }

    public void fillShampooTank(int amount) {
        if (shampooTankLevel + amount <= MAX_SHAMPOO_TANK) {
            shampooTankLevel += amount;
        } else {
            System.out.println("Reservatório de shampoo está cheio");
        }
    }

    public void checkWaterLevel() {
        var level = getWaterTankLevel();

        System.out.printf("O reservatório de água tem %d litros\n", level);
    }

    public void checkShampooLevel() {
        var level = getShampooTankLevel();

        System.out.printf("O reservatório de shampoo tem %d litros\n", level);
    }

    public void existPetMachine() {
        var pet = getInsideWashMachine();

        if (pet != null) {
            System.out.printf("O pet %s está na máquina\n", pet.getName());
        } else {
            System.out.println("A máquina está vazia");
        }
    }

    public void putPetOnMachine(Pet pet) {
        var useWater = 10;
        var useShampoo = 2;
        var waterLevel = getWaterTankLevel();
        var shampooLevel = getShampooTankLevel();
        var washMachineFull = getInsideWashMachine();
        var newWaterLevel = waterLevel - useWater;
        var newShampooLevel = shampooLevel - useShampoo;


        if (waterLevel < useWater || shampooLevel < useShampoo) {
            System.out.println("Abastecer água e shampoo antes de colocar outro pet");
        } else {
            if (washMachineFull == null) {
                pet = witchPet(pet);
                setInsideWashMachine(pet);
                setWaterTankLevel(newWaterLevel);
                setShampooTankLevel(newShampooLevel);
                System.out.printf("O pet %s foi colocado na máquina\n", pet.getName());
            } else {
                System.out.println("Já tem um pet na máquina");
            }
        }
    }

    public void takeOutPet(Pet pet) {
        var washMachineFull = getInsideWashMachine();

        if (washMachineFull != null) {
            setInsideWashMachine(null);
            pet.setClean(true);
            System.out.println("O pet foi retirado da máquina");
        } else {
            System.out.println("A máquina está vazia");
        }
    }

    public void cleanMachine() {
        var useWater = 3;
        var useShampoo = 1;
        var waterLevel = getWaterTankLevel();
        var shampooLevel = getShampooTankLevel();
        var pet = getInsideWashMachine();


        if (pet != null) {
            System.out.println("Ainda tem um pet na máquina");
        } else if (waterLevel < useWater && shampooLevel < useShampoo) {
            System.out.println("Abastecer água e shampoo antes de limpar a máquina");
        } else {
            var newWaterLevel = waterLevel - useWater;
            var newShampooLevel = shampooLevel - useShampoo;

            setWaterTankLevel(newWaterLevel);
            setShampooTankLevel(newShampooLevel);

            System.out.println("Máquina limpa com sucesso");
        }
    }

    public Pet witchPet(Pet pet) {
        var scanner = new Scanner(System.in);

        System.out.println("Digite o nome do pet: ");

        var name = scanner.next();

        pet.setName(name);

        return pet;
    }
}


