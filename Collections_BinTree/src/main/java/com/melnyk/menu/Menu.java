package com.melnyk.menu;

import com.melnyk.bintree.MyBinTree;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

  private Map<String, String> menu;
  private Map<String, Printable> menuMethods;
  private static Scanner input = new Scanner(System.in);
  private static Scanner inputInt = new Scanner(System.in);
  private MyBinTree<Integer, String> binTree = new MyBinTree<>();

  public void myMenu() {
    menu = new LinkedHashMap<>();
    menuMethods = new LinkedHashMap<>();
    menu.put("1", "1 - Add new value");
    menu.put("2", "2 - Get value by key");
    menu.put("3", "3 - Remove value by key");
    menu.put("4", "4 - Check for contains key");
    menu.put("5", "5 - Check is Binary Tree empty");
    menu.put("6", "6 - Show Binary Tree");
    menu.put("Q", "Q - Exit");

    menuMethods.put("1", this::put);
    menuMethods.put("2", this::get);
    menuMethods.put("3", this::remove);
    menuMethods.put("4", this::containsKey);
    menuMethods.put("5", this::isEmpty);
    menuMethods.put("6", this::showBinTree);
  }

  private void outputMenu() {
    System.out.println("\n\tMENU:");
    for (String string : menu.values()) {
      System.out.println(string);
    }
  }

  public void show() {
    String keyMenu;
    do {
      outputMenu();
      System.out.print("Pleas, select menu point: ");
      keyMenu = input.nextLine().toUpperCase();
      try {
        menuMethods.get(keyMenu).print();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } while (!keyMenu.equals("Q"));
  }

  private void put() {
    System.out.print("Print Integer key: ");
    Integer key = inputInt.nextInt();
    System.out.print("Print String value: ");
    String value = input.nextLine().toUpperCase();
    binTree.put(key, value);
  }

  private void get() {
    System.out.print("Print Integer key: ");
    Integer key = input.nextInt();
    binTree.get(key);
  }

  private void remove() {
    System.out.print("Print Integer key: ");
    Integer key = input.nextInt();
    binTree.remove(key);
  }

  private void containsKey() {
    System.out.print("Print Integer key: ");
    Integer key = input.nextInt();
    binTree.containsKey(key);
  }

  private void isEmpty() {
    System.out.println(binTree.isEmpty() ? "Yes" : "No");
  }

  private void showBinTree() {
    binTree.showBinTree();
  }
}

