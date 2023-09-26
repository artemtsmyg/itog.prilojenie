package org.example.Prilojenie;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Класс, представляющий информацию о человеке.
 */
public class Person {
    /**
     * Поля где написаны какую информацию нужно предоставить
     * 1)фамилия
     * 2)имя
     * 3)отчество
     * 4)дата рождения
     * 5)номер телефона
     * 6)пол
     */
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;

    /**
     * Конструктор для создания объекта Person
     * @param lastName Фамилия человека.
     * @param firstName Имя человека.
     * @param middleName Отчество человека.
     * @param birthDateStr Строка с датой рождения в формате "dd.MM.yyyy".
     * @param phoneNumber Номер телефона человека.
     * @param gender Пол человека ('м' - мужской, 'ж' - женский).
     * @throws ParseException Если не удается распарсить строку с датой рождения.
     */
    public Person(String lastName, String firstName, String middleName, String birthDateStr, long phoneNumber, char gender) throws ParseException {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.birthDate = dateFormat.parse(birthDateStr);

        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    /**
     * Получить фамилию человека.
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Получить имя человека.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Получить отчество человека.
     * @return
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Получить дату рождения человека.
     * @return
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Получить номер телефона человека.
     * @return
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Получить пол человека.
     * @return
     */
    public char getGender() {
        return gender;
    }
}
