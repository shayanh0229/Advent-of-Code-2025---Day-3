import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // **** DO NOT EDIT CODE HERE ****
        ArrayList<String> fileData = getFileData("data");
        int answer = 0;
        for (String fileDatum : fileData) {
            answer += getWage(fileDatum);
        }
        System.out.println("Answer: " + answer);

    }

    // *** COMPLETE THIS METHOD
    // This method should return the wage owed to this elf
    // given a workday String (represented by "data")
    // For example:
    // if data is "057810019412"
    // this method should return 296
    public static int getWage(String data) {
        int wage = 0;
    for (int i = 0; i < data.length(); i++) {
        if (i < 2 || i > 9) {
            if (Integer.parseInt(data.substring(i,i+1)) > 0) {
                wage += 40 + (Integer.parseInt(data.substring(i,i+1)) * 2);
            }
        } else {
             wage += 20;
        }
    }

        return wage;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}