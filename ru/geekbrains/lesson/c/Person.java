package ru.geekbrains.lesson.c;

import java.util.ArrayList;
import java.util.Collections;

public class Person {

    private String lastname;
    private ArrayList<String> phones;
    private ArrayList<String> emails;

   Person(String lastname) {
       this.lastname = lastname;
        phones = new ArrayList<>();
        emails = new ArrayList<>();
    }

    Person(String lastname, String phone, String email) {
        this.lastname = lastname;
        phones = new ArrayList<>();
        phones.add(phone);
        emails = new ArrayList<>();
        emails.add(email);
    }

    Person(String lastname, ArrayList<String> phones, ArrayList<String> emails) {
        this.lastname = lastname;
        this.phones.addAll(phones);
        this.emails.addAll(emails);
    }

    Person(String lastname, String[] phones, String[] emails) {
        this.lastname = lastname;
        this.phones = new ArrayList<>();
        Collections.addAll(this.phones, phones);
        this.emails = new ArrayList<>();
        Collections.addAll(this.emails, emails);
    }

    public void addEmails(ArrayList<String> emails) {
        this.emails.addAll(emails);
    }

    public void addPhones(ArrayList<String> phones) {
        this.phones.addAll(phones);
    }

    public void addEmails(String[] emails) {
        Collections.addAll(this.emails, emails);
    }

    public void addPhones(String[] phones) {
        Collections.addAll(this.phones, phones);
    }

    public void addEmails(String email) {
        this.emails.add(email);
    }

    public void addPhones(String phone) {
        this.phones.add(phone);
    }

    public void clearEmails() {
        this.emails.clear();
    }

    public void clearPhones() {
        this.phones.clear();
    }

    public ArrayList getPhones() {
        return phones;
    }
    public ArrayList getEmails() {
        return emails;
    }
    public String getLastname() {
        return lastname;
    }
}


