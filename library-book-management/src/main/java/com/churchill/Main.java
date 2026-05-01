package com.churchill;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
   public static void main(String[] args){
       while (true){
           System.out.println("Select a task to perform");
           System.out.println("\n1. Add Animal");
           System.out.println("2. Remove Animal");
           System.out.println("3. Search");
           System.out.println("4. Display All");
           System.out.println("5. Update Animal");
           System.out.println("6. Exit");

           int choice = scanner.nextInt();

           switch (choice){
               case 1:
                   System.out.println("Number 1");
                   break;
               case 2:
                   System.out.println("NUmber 2");
                   break;
           }
       }
   }
}
