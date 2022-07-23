package Project.util;


import Project.model.Group;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class GroupListLoad {

    public void groupListLoad(List<Group> groups) throws IOException {

        String str = "";
        FileReader fileReader = null;

        try {
            fileReader = new FileReader("GroupList.txt");
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
            s.trim();
            String[] str2 = s.split(" ");
            groups.add(new Group(convert(str2[0]), convert(str2[1]), convert(str2[2]), convert(str2[3])));
        }
    }

    private static int convert(String str) {
        int i = 0;
        try {
            i = Integer.parseInt(str.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return i;
    }
}
