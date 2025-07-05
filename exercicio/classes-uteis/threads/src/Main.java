import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Queue<Integer> numbers = new LinkedBlockingQueue<>(250);

    private static void inc(int number) {
        numbers.add(number);
    }
    private static void desc(int number) {
        numbers.add(number);
    }
    private static void show() {
        System.out.println(numbers);
    }

    public static void main(String[] args) {
        Runnable inc = () -> {
            for (int i = 0; i < 100; i++) {
                inc(i);
            }
        };

        Runnable desc = () -> {
            for (int i = 100; i >= 0; i--){
                desc(i);
            }
        };

        Runnable show = () -> {
            for (int i = 0; i < 250; i++) {
                show();
            }
        };

        new Thread(inc).start();
        new Thread(desc).start();
        new Thread(show).start();

    }
}