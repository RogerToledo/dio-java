//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var brClock = new BRClock();

        brClock.setHour(11);
        brClock.setMinute(10);
        brClock.setSecond(54);

        var time = brClock.getTime();

        System.out.println(time);
        System.out.println(new USClock().convert(brClock).getTime());
    }
}