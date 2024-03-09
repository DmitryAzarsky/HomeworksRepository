package HW12;

public class Exercise2 {
    static int current = 1;
    public static void main(String[] args) {
        int n = 15;
        Object lock = new Object();
        Thread printFizz = new Thread(() -> {
            for (int i = 0; current <= n; i++) {
                synchronized (lock) {
                    if (current % 3 == 0 && current % 5 != 0) {
                        System.out.println("fizz");
                        current++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread printBuzz = new Thread(() -> {
            for (int i = 0; current <= n; i++) {
                synchronized (lock) {
                    if (current % 3 != 0 && current % 5 == 0) {
                        System.out.println("buzz");
                        current++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread printFizzBuzz = new Thread(() -> {
            for (int i = 0; current <= n; i++) {
                synchronized (lock) {
                    if (current % 3 == 0 && current % 5 == 0) {
                        System.out.println("fizzbuzz");
                        current++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread printNormal = new Thread(() -> {
            for (int i = 0; current <= n; i++) {
                synchronized (lock) {
                    if (current % 3 != 0 && current % 5 != 0) {
                        System.out.println(current);
                        current++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        printFizz.start();
        printNormal.start();
        printBuzz.start();
        printFizzBuzz.start();
    }
}
