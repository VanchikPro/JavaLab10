package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        apacheCommonsIODemo();

        jacksonDemo();
    }

    // метод для работы с файлами
    public static void apacheCommonsIODemo() throws IOException {
        File file = new File("demo.txt");
        String content = "Этот текст, записан с помощью Apache Commons IO.";

        FileUtils.writeStringToFile(file, content, "UTF-8");
        System.out.println("Файл успешно записан.");

        // чтение текста из файла
        String readContent = FileUtils.readFileToString(file, "UTF-8");
        System.out.println("Содержимое файла: " + readContent);
    }

    // метод для работы с JSON
    public static void jacksonDemo() throws IOException {
        Person person = new Person("Иван", 21);
        ObjectMapper mapper = new ObjectMapper();

        // сериализация
        String json = mapper.writeValueAsString(person);
        System.out.println("Объект в JSON: " + json);
        // десериализация
        Person deserializedPerson = mapper.readValue(json, Person.class);
        System.out.println("Объект после десериализации: " + deserializedPerson);

    }
}