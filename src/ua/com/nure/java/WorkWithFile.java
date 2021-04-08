package ua.com.nure.java;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithFile {

    private static final String PATH_OUT = "finding_words.txt";

    public String readFile(String path){
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            Logger.getLogger(ex.toString());
        }
        return sb.toString();
    }

    private void writeToFile(String text){
        try {
            FileWriter writer = new FileWriter(PATH_OUT, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(text);
            bufferWriter.close();
        } catch (IOException e){
            Logger.getLogger(e.toString());
        }
    }

    public void findWord (String word, String text){
        StringBuilder builder = new StringBuilder();
        Pattern p = Pattern.compile("(?i)\\b(" + word + ")\\b");
        Matcher m = p.matcher(text);
        while (m.find()){
            builder.append(m.group());
            builder.append(" ");
        }
        builder.append(" ");
        writeToFile(builder.toString());
    }
}
