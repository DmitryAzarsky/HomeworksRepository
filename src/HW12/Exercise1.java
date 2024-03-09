package HW12;

public class Exercise1 {
    public static void main(String[] args) {
        int time = 6;
        Thread timePrinter = new Thread(() -> {
            long currentTime = 0;
            for (int i = 0; i < time; i++) {

                try {
                    System.out.println(currentTime);
                    currentTime++;
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(currentTime);
        });
        Thread fiveSecondsDelayPrinter = new Thread(() -> {
            for (int i = 0; i < (time/5); i++) {
                try {
                    Thread.sleep(5000L);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        timePrinter.start();
        fiveSecondsDelayPrinter.start();
    }
}
