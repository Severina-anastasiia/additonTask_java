package ua.com.nure.java;

public class Main {

    public static void main(String[] args) {
        WorkWithFile work = new WorkWithFile();
        String input = work.readFile("input.txt");
        System.out.println(input);
        work.findWord("world", input);
        work.findWord("hello", input);
        work.findWord("when", input);
        String input_ru = work.readFile("input_ru.txt");
        System.out.println(input_ru);
        work.findWord("доступ", input_ru);
    }
}
