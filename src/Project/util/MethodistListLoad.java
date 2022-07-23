package Project.util;

import Project.model.Address;
import Project.model.Methodist;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MethodistListLoad {
    public void methodistListLoad(List<Methodist> met) throws IOException {

        String str = "";
        FileReader fileReader = null;

        try {
            fileReader = new FileReader("MethodistList.txt");
            int a;
            while ((a = fileReader.read()) != -1) {
                str += (char) a;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        String[] str1 = str.split("\n");
        for (String s : str1) {
            String[] str2 = s.split(" ");
            met.add(new Methodist(str2[0], str2[1], str2[2], Integer.parseInt(str2[3]), Integer.parseInt(str2[4]), new Address(str2[5], str2[6], str2[7], convert(str2[8]))));
        }
    }


    private static int convert(String str) {
        int i = 0;
        try {
            i = Integer.parseInt(str.trim());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }
        return i;
    }
}
