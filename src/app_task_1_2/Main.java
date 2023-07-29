package app_task_1_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger counter = new AtomicInteger(0);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String title;
        Set<String> list = getData(sc);
        title = "Your product list:";
        getOutput(title, list);
        title = "Your updated product list:";
        getOutput(title, addToTheList(list));
        getOutput(title, removeFromTheList(list));

        sc.close();
    }

    private static Set<String> getData(Scanner sc) {

        System.out.println("\nHow many products do you want to add to the list?: ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.println("\nMaking list with " + num + " products . . .");

        Set<String> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            counter.incrementAndGet();
            System.out.print(counter + ")" + " product: ");
            String product = sc.nextLine().toLowerCase();

            if (!(set.add(product))) {
                System.out.println(product + " - is already in the list. Try one more time.");
                counter.decrementAndGet();
                i--;
            }
        }
        return set;
    }

    private static void getOutput(String title, Set<String> set) {
        counter.set(0);
        System.out.println("\n" + title);
        for (String list : set) {
            counter.incrementAndGet();
            System.out.println(counter + ") " + list);
        }
    }

    private static Set<String> addToTheList(Set<String> set) {

        System.out.println("\nThere are " + set.size() + " products already in the list.");

        System.out.println("\nHow many products do you want to add to the list?: ");
        counter.set(set.size());
        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            counter.incrementAndGet();
            System.out.print(counter + ")" + " product: ");
            String product = sc.nextLine().toLowerCase();

            if (!(set.add(product))) {
                System.out.println(product + " - is already in the list. Try one more time.");
                counter.decrementAndGet();
                i--;
            }
        }
        return set;
    }

    private static Set<String> removeFromTheList(Set<String> set) {
        System.out.println("\nHow many products do you want to remove from the list?: ");
        counter.set(0);
        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            counter.incrementAndGet();
            System.out.print(counter + ")" + " product: ");
            String product = sc.nextLine().toLowerCase();

            if (!(set.remove(product))) {
                System.out.println(product + " - is not in the list. Try one more time.");
                counter.decrementAndGet();
                i--;
            }
        }
        return set;
    }
}