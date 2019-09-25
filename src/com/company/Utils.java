package com.company;

import java.util.Scanner;

public class Utils {

    static Scanner scanner = new Scanner(System.in);

    public static String ask(String question){
        System.out.println(question);
        return scanner.nextLine();
    }

    public static void display(String str){
        System.out.println(str);
    }

}
