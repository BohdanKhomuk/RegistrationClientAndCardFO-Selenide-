package com.test.methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gender {

    private String gender = ConfigProperties.getTestProperty ( "gender" );


    public String enterGenderNum() {
        String genderNum = "";
        if (gender.equals ( "men" )) {
            genderNum ="1";
        }
        else if(gender.equals ( "women" )) {
            genderNum = "2";
        }
        else{
            System.out.println ( "Enter is not the right to enter a 'man' or a 'women'" );
        }
        return genderNum;
    }


    public String Name() throws FileNotFoundException {
        String fileName = String.format( "/Name%s.txt", enterGenderNum ());
        Scanner sc = new Scanner(new File( RandomWordsAndNumber.class.getResource(fileName).getFile()), "cp1251");

        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        String str1 = sb.toString().replaceAll("\"", "");
        String[] str = str1.split(", ");

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
        String[] str = str1.split(", ");

        int n = (int) Math.floor(Math.random() * str.length);

        return str[n];
    }

    public String Patronymic() throws FileNotFoundException {
        String fileName = String.format( "/Patronymic%s.txt", enterGenderNum () );
        Scanner sc = new Scanner(new File( RandomWordsAndNumber.class.getResource(fileName).getFile()), "cp1251");

        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();

        String str1 = sb.toString().replaceAll("\"", "");
        String[] str = str1.split(", ");

        int n = (int) Math.floor(Math.random() * str.length);

        return str[n];
    }
}
