package org.example;

import org.example.Prilojenie.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Главный класс приложения.
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * Запрашиваем данные у пользователя
         */
        System.out.println("Введите данные в формате: Фамилия Имя Отчество дд.мм.гггг номерТелефона пол");
        String inputLine = scanner.nextLine().trim();

        String[] data = inputLine.split(" ");

        /**
         * Проверяем количество введенных данных
         */
        if (data.length != 6) {
            System.err.println("Ошибка: Введено недостаточно или слишком много данных.");
            return;
        }

        try {
            /**
             * Парсим данные и создаем объект Person
             */
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDateStr = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            Person person = new Person(lastName, firstName, middleName, birthDateStr, phoneNumber, gender);

            /**
             * Создаем файл с именем, равным фамилии
             */
            String fileName = lastName + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true); // true - для добавления в конец файла

            /**
             * Записываем данные в файл
             */
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String formattedDate = dateFormat.format(person.getBirthDate());

            String fileContent = String.format("%s%s%s %s %d %c%n",
                    person.getLastName(), person.getFirstName(), person.getMiddleName(),
                    formattedDate, person.getPhoneNumber(), person.getGender());

            fileWriter.write(fileContent);
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл: " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Неверный формат номера телефона.");
        } catch (ParseException e) {
            System.err.println("Ошибка: Неверный формат даты рождения.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл.");
        }
    }
}