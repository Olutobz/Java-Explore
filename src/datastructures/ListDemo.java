package datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(3);
        list1.add(null);
        System.out.println("list1: " + list1);

        list1.remove(3);
        System.out.println("list1: " + list1);

        list1.remove(3);
        System.out.println("list1: " + list1);

        // Bulk Operations
        Collection<Integer> list2 = new ArrayList<>();
        list2.add(9);
        list2.add(3);
        list2.add(13);

        System.out.println("list2: " + list2);

        list1.removeAll(list2);
        System.out.println("list1: " + list1);

        list2.add(1);

        list1.retainAll(list2);
        System.out.println("list1: " + list1);

        list1.addAll(list2);
        System.out.println("list1: " + list1);

        System.out.println("list1.set(2,2): " + list1.set(2, 2));

        // Search
        System.out.println("list1.contains(1): " + list1.contains(1));
        System.out.println("list1.indexOf(1): " + list1.indexOf(1));
        System.out.println("list1.lastIndexOf(1): " + list1.lastIndexOf(1));
        System.out.println("list1: " + list1);

        // Range-view: subList (new list is backed by original)
        List<Integer> list3 = list1.subList(2, 3);
        list3.set(0, 6);
        System.out.println("list: " + list1);
        list3.add(0, 7);
        System.out.println(list3);
        System.out.println("list1: " + list1);

        listIteratorDemo();

    }

    static void listIteratorDemo() {
        System.out.println("Inside listIteratorDemo ...");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("Displaying current elements ...");
        for (ListIterator<String> iterator = list.listIterator(); iterator.hasNext(); ) {
            System.out.println("Iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());
        }

    }

}