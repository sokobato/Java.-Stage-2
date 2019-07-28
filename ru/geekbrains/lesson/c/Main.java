package ru.geekbrains.lesson.c;

import java.util.*;

/**
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 - Написать метод, который найдет список слов, из которых состоит список (дубликаты не считать)
 - Написать метод, который посчитает сколько раз встречается каждое слово
2. Написать простой класс PhoneBook
 - В качестве ключа использовать фамилию.
 - В каждой записи всего два поля phone, e-mail.
 - Отдельный метод для поиска по фамилии(ввели фамилию получили ArrayList телефонов ... за экран вылезло, хз
и отдельный метод поиска для e-mail по фамилии
 Следует учесть что под одной фамилией может быть нес оклько записей*/

public class Main {
    public static void main(String[] args) {
        String[] words = {"sarry", "marry", "carry", "farry", "tyrry", "carry", "sarry", "rarry", "durry", "furry", "sarry"};
    //1 найдет список слов
        //[durry, farry, marry, sarry, carry, rarry, furry, tyrry]
        Object[] wordsunique = getUniqueWords(words);
        System.out.println(Arrays.toString(wordsunique));
    //1 найдет количество встреч слов
         /*[durry, 1]
           [farry, 1]
           [marry, 1]
           [sarry, 3]
           [carry, 2]
           [rarry, 1]
           [furry, 1]
           [tyrry, 1]*/
        Object[][] wordscount = getCountWords(words);
        for (Object[] arr : wordscount) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("***********************");

        //2

        PhoneBook personbook = new PhoneBook();

        personbook.addRow("asa", "62313213", "fla@fla.ru");
        personbook.addRow("ava", "123213", "");
        personbook.addRow("ara", new String[]{"45435345", "89798798"}, new String[]{""});
        personbook.addRow("ata", "345435", "");
        personbook.addRow("ama", "345435", "");
        personbook.addRow("ala", "657657657", "");
        personbook.addRow("ada", "345345435", "");
        personbook.addRow("afa", "3454355345", "");
        personbook.addRow("aca", "12312326513", "");

        try {System.out.println(personbook.getPersonEmails("asa"));
        }catch (NullPointerException e) {
            System.out.println("Запись не нашли; Ошибка: " + e.getMessage());}
        try {System.out.println(personbook.getPersonPhones("asa"));
        }catch (NullPointerException e) {
            System.out.println("Запись не нашли; Ошибка: " + e.getMessage());}
        try {System.out.println(personbook.getPersonPhones("ara"));
        }catch (NullPointerException e) {
            System.out.println("Запись не нашли; Ошибка: " + e.getMessage());}
        try {System.out.println(personbook.getPersonPhones("ada1"));
        }catch (NullPointerException e) {
            System.out.println("Запись не нашли; Ошибка: " + e.getMessage());}

    }

   private static Object[] getUniqueWords(String[] words){
       Set<String> uniq = new HashSet<>(Arrays.asList(words));
       return uniq.toArray();
   }

    private static Object[][] getCountWords(String[] words){
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // J1 Stream190617... (вот тут мутор)
        return map.entrySet().stream().map(e -> new Object[]{e.getKey(), e.getValue()}).toArray(Object[][]::new);
    }

}
