package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


while (true) {
    try {
        LocalDate today= LocalDate.now();
            int year=today.getYear();


        Scanner sc = new Scanner(System.in);
        int workExperience;
        System.out.println("Введите имя работника:");
        String name=sc.nextLine();
        if (!name.matches("^[a-zA-Z]*$")) {
            throw new MyException("no");
        }

        System.out.println("Введите фамилию работника:");
        String surname = sc.nextLine() ;
        if (!surname.matches("^[a-zA-Z]*$")) {
            throw new MyException("no");
        }

        System.out.println("Введите год рождения работника:");
        int yearOfBirth = sc.nextInt();
        if (yearOfBirth > year) {


            throw new MyException("Нельзя вводить данные из будущего!!!");
        }
        System.out.println("Введите год начала работы:");
        int yearStart = sc.nextInt();
        if (yearStart > year) {
            throw new MyException("Нельзя вводить данные из будущего!!!");
        }
        if (yearOfBirth>2004) {
            throw new MyException("Нельзя вводить год начала работы более раннего, чем год, когда работнику испольнилось 18 лет");
        }
        if (yearStart < year) {
            workExperience = (yearStart-yearOfBirth)-18;
            System.out.println("Стаж работы работника: " + workExperience);

        }

    } catch (MyException e) {
        System.out.println(e.getMessage());
    } catch (InputMismatchException inputMismatchException) {
        System.out.println("Данные должны состоять из цифр!!!");
    }
}
    }
}
