package ru.geekbrains.lesson.c;

import java.util.*;

public class PhoneBook {

    private Map<String, Person> map;

    PhoneBook() {
        this.map = new HashMap<>();
    }

    void addRow(String lastname, String phone, String email) {

        Person person;

        if (map.containsKey(lastname)) {
            person = map.get(lastname);
        } else {
            person = new Person(lastname);
        }

        person.addPhones(phone);
        person.addEmails(email);
        map.put(lastname, person);

    }
    void addRow(String lastname, String[] phones, String[] emails) {

        Person person;

        if (map.containsKey(lastname)) {
            person = map.get(lastname);
        } else {
            person = new Person(lastname);
        }

        person.addPhones(phones);
        person.addEmails(emails);
        map.put(lastname, person);

    }

    void addRow(String lastname, ArrayList<String> phones, ArrayList<String> emails) {

        Person person;

        if (map.containsKey(lastname)) {
            person = map.get(lastname);
        } else {
            person = new Person(lastname);
        }

        person.addPhones(phones);
        person.addEmails(emails);
        map.put(lastname, person);

    }


    public Person getPerson(String lastName) throws NullPointerException{
        return map.get(lastName);
    }

    public ArrayList<String> getPersonPhones(String lastName) throws NullPointerException{
        return map.get(lastName).getPhones();
    }

    public ArrayList<String> getPersonEmails(String lastName) throws NullPointerException{
        return map.get(lastName).getEmails();
    }

}