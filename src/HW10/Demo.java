package HW10;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;

public class Demo{
    public void readAndPrint() {
        try(FileInputStream fIs = new FileInputStream("exercise2Output.json")){
            Scanner scanner = new Scanner(fIs);
            String s2 = "";
            while (scanner.hasNext()){
                String s = scanner.nextLine();
                s2 += s;
            }
            List<Person> p2 = new Gson().fromJson(s2, new TypeToken<List<Person>>(){}.getType());
            for(int i = 0; i<p2.size(); i++) {
                System.out.println(p2.get(i).toString());
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


