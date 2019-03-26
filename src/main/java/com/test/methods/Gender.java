package com.test.methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gender {

    public int gender = 2; // 1-men, 2-women

    public String Name() throws FileNotFoundException {
        String fileName = String.format( "/Name%s.txt", gender );
        Scanner sc = new Scanner(new File( RandomWordsAndNumber.class.getResource(fileName).getFile()), "cp1251");

        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        String str1 = sb.toString().replaceAll("\"", "");
        String[] str = str1.toString().split(", ");

        int n = (int) Math.floor(Math.random() * str.length);

        return str[n];
    }

    public String Surname() throws FileNotFoundException {
        Scanner sc = new Scanner(new File( RandomWordsAndNumber.class.getResource("/Surname.txt").getFile()), "cp1251");

        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        String str1 = sb.toString().replaceAll("\"", "");
        String[] str = str1.toString().split(", ");

        int n = (int) Math.floor(Math.random() * str.length);

        return str[n];
    }

    public String Patronymic() throws FileNotFoundException {
        String fileName = String.format( "/Patronymic%s.txt", gender );
        Scanner sc = new Scanner(new File( RandomWordsAndNumber.class.getResource(fileName).getFile()), "cp1251");

        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        String str1 = sb.toString().replaceAll("\"", "");
        String[] str = str1.toString().split(", ");

        int n = (int) Math.floor(Math.random() * str.length);

        return str[n];
    }
}
