import java.util.Scanner;

public class Main {
    private static Car car;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var option = -1;

        do{
            System.out.println("=== Escolha uma opção ===");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar carro");
            System.out.println("2 - Ligar/Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Desacelerar");
            System.out.println("5 - Virar Direita/Esquerda");
            System.out.println("6 - Verificar velocidade");
            System.out.println("7 - Subir marcha");
            System.out.println("8 - Descer marcha");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> createCar();
                case 2 -> turnOnOff();
                case 3 -> accelerate();
                case 4 -> slowDown();
                case 5 -> turnRightLeft();
                case 6 -> checkVelocity();
                case 7 -> shiftUp();
                case 8 -> shiftDown();
                default -> System.out.println("Digite uma opção válida");
            }

        }while(option != 0);

        System.exit(-1);
    }

    private static void createCar() {
        car = new Car();

        System.out.println("Carro criado com sucesso");
    }

    private static void shiftDown() {
        var isCarOn = car.isOn();
        var shift = car.getShift();
        var velocity = car.getVelocity();
        var canShiftDown = rulesShiftDown(velocity);

        if (isCarOn) {
            if (canShiftDown) {
                if (shift > 0) {
                    var newShift = shift - 1;
                    car.setShift(newShift);
                    System.out.printf("Você mudou para marcha %d\n", newShift);
                } else {
                    System.out.println("Você está em ponto morto");
                }
            } else {
                System.out.println("Você não pode mudar de marcha");
            }
        } else {
            System.out.println("O carro está desligado");
        }
    }

    private static void shiftUp() {
        var isCarOn = car.isOn();
        var shift = car.getShift();
        var velocity = car.getVelocity();
        var canShiftUp = rulesShiftUp(velocity);

        if (isCarOn) {
            if (canShiftUp) {
                if (shift < 6) {
                    var newShift = shift + 1;
                    car.setShift(newShift);
                    System.out.printf("Você mudou para marcha %d\n", newShift);
                } else {
                    System.out.println("Você já está na última marcha");
                }
            } else {
                System.out.println("Você não pode subir marcha nessa velocidade");
            }
        } else {
            System.out.println("O carro está desligado");
        }
    }

    private static void checkVelocity() {
        var velocity = car.getVelocity();
        System.out.printf("Você está a %d Km/h\n", velocity);
    }

    private static void turnRightLeft() {
        var velocity = car.getVelocity();

        if (velocity >= 1 && velocity <= 40) {
            System.out.println("Você está virando o carro");
        } else {
            System.out.println("Você não pode virar o carro com velocidade menor que 1Km/h em maior que 40Km/h");
        }
    }

    private static void slowDown() {
        var isCarOn = car.isOn();
        var velocity = car.getVelocity();
        var canSlowDown = rulesSlowDown(velocity);

        if (isCarOn) {
            if (canSlowDown) {
                if (velocity > 0) {
                    var newVelocity = velocity - 1;
                    car.setVelocity(newVelocity);
                    System.out.printf("Você está a %d km/h\n", newVelocity);
                } else {
                    System.out.println("Você já está parado");
                }
            } else {
                System.out.println("Você precisa reduzir a marcha para continuar desacelerando");
            }
        } else {
            System.out.println("Você precisa ligar o carro para desacelerar");
        }
    }

    private static void accelerate() {
        var isCarOn = car.isOn();
        var velocity = car.getVelocity();
        var isVelocity = true;
        var canAccelerate = rulesAccelerate(velocity);

        if (isCarOn) {
            if (canAccelerate) {
                if (velocity < 120) {
                    var newVelocity = velocity + 1;
                    car.setVelocity(newVelocity);
                    System.out.printf("Você está a %d km/h\n", newVelocity);
                }
            } else {
                System.out.println("Você não pode acelerar por causa da velocidade ou marcha");
            }
        } else {
            System.out.println("Você precisa ligar o carro para acelerar");
        }
    }

    private static void turnOnOff() {
        var isOn = car.isOn();
        var shift = car.getShift();

        if (!isOn) {
            if (shift == 0) {
                car.setOn(true);
                System.out.println("O carro está ligado");
            } else {
                System.out.println("O carro não está em ponto morto");
            }
        } else {
            var velocity = car.getVelocity();
            if (velocity == 0 & shift == 0) {
                car.setOn(false);
                System.out.println("O carro está desligado");
            } else {
                System.out.println("Você precisa parar o carro e colocar em ponto morto para desligar");
            }
        }
    }

    private static boolean rulesAccelerate(int velocity) {
        var shift = car.getShift();
        if (shift == 0) {
            return false;
        } else if (shift == 1 && velocity >= 0 && velocity < 20) {
            return true;
        } else if (shift == 2 && (velocity >= 20 && velocity < 40)) {
            return true;
        } else if (shift == 3 && (velocity >= 40 && velocity < 60)) {
            return true;
        } else if (shift == 4 && (velocity >= 60 && velocity < 80)) {
            return true;
        } else if (shift == 5 && (velocity >= 80 && velocity < 100)) {
            return true;
        } else return shift == 6 && (velocity >= 100 && velocity < 120);
    }

    private static boolean rulesSlowDown(int velocity) {
        var shift = car.getShift();
        if (shift == 0) {
            return false;
        } else if (shift == 1 && velocity > 0 && velocity <= 20) {
            return true;
        } else if (shift == 2 && (velocity > 20 && velocity <= 40)) {
            return true;
        } else if (shift == 3 && (velocity > 40 && velocity <= 60)) {
            return true;
        } else if (shift == 4 && (velocity > 60 && velocity <= 80)) {
            return true;
        } else if (shift == 5 && (velocity > 80 && velocity <= 100)) {
            return true;
        } else return shift == 6 && (velocity > 100 && velocity <= 120);
    }

    private static boolean rulesShiftUp(int velocity) {
        var shift = car.getShift();
        if (shift == 0) {
            return true;
        } else if (shift == 1 && velocity == 20) {
            return true;
        } else if (shift == 2 && velocity == 40) {
            return true;
        } else if (shift == 3 && velocity == 60) {
            return true;
        } else if (shift == 4 && velocity == 80) {
            return true;
        } else if (shift == 5 && velocity == 100) {
            return true;
        } else return shift == 6 && velocity == 120;
    }

    private static boolean rulesShiftDown(int velocity) {
        var shift = car.getShift();
        if (shift == 0) {
            return false;
        } else if (shift == 1 && velocity == 0) {
            return true;
        } else if (shift == 2 && velocity == 20) {
            return true;
        } else if (shift == 3 && velocity == 40) {
            return true;
        } else if (shift == 4 && velocity == 60) {
            return true;
        } else if (shift == 5 && velocity == 80) {
            return true;
        } else return shift == 6 && velocity == 100;
    }
}
