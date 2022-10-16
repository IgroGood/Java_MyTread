import java.util.Arrays;


public class Main {
    static int countElements = 100000000;
    static Character[] mass = new Character[countElements];
    public static void main(String[] args) {
        for (int i = 0; i < countElements; i++)
            mass[i] = ' ';
        System.out.println("mass size: " + mass.length);
        MyTread treadX = new MyTread("X", mass, 'X', 0, 1);
        MyTread treadY = new MyTread("Y", mass, 'Y', mass.length -1, -1);
        treadX.start();
        treadY.start();
        while (treadX.isAlive() || treadY.isAlive());
        System.out.println("Рауд завершен! Идет подсчет...");
        long countX = Arrays.stream(mass).filter(character -> character == 'X').count();
        long countY = Arrays.stream(mass).filter(character -> character == 'Y').count();
        System.out.printf("count X: %d - %f%%\n", countX, (float) (countX * 100) / countElements);
        System.out.printf("count Y: %d - %f%%\n", countY, (float) (countY * 100) / countElements);
        System.out.println(countX > countY ? "win X" : (countX < countY ? "win Y" : "Ничья."));
    }
}
