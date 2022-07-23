package Project.util;

import Project.model.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class StudentListLoad {
    public void studentListLoad(List<Group> groups) throws IOException {
        String str = "";
        FileReader fileReader = null;

        try {
            fileReader = new FileReader("StudentList.txt");
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
        String[] str3 = str.split("/");
        for (int i = 0; i < str3.length; i++) {
            String[] str1 = str3[i].split("\n");
            for (String s : str1) {
                String[] str2 = s.split(" ");
                if (str2.length > 7) {
                    groups.get(i).getStud().add(new Student(str2[0], str2[1], str2[2], Integer.parseInt(str2[3]), new Address(str2[4], str2[5], str2[6], convert(str2[7]))));
                }
            }
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
