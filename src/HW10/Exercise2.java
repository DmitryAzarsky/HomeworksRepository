package HW10;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.*;
//import com.google.gson.*;
public class Exercise2{
    public void rewriteFromFileToJSONFile() {
        List<Person> persons = new ArrayList<>();
        File textFile = new File("./files/file.txt");
        try (FileInputStream fIs = new FileInputStream(textFile)) {
            Scanner fileScanner = new Scanner(fIs);
            for (int i = 0; fileScanner.hasNext(); i++) {
                String[] dataFromLine =  fileScanner.nextLine().split(" ");
                if (i==0) continue;
                persons.add(new Person(dataFromLine[0], Integer.parseInt(dataFromLine[1])));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try(Writer writer = new FileWriter("exercise2Output.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(persons, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class Person{
    private String name;
    private int age;
    @Override
    public String toString() {
        return "Name = " + name + ", age = " + age;
    }
    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
