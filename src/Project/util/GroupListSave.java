package Project.util;

import Project.model.Group;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GroupListSave {
    public void groupListSave(List<Group> groups) throws IOException {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("GroupList.txt");
            for (Group line : groups) {
                fileWriter.write(String.valueOf(line.getGroup()) + " ");
                fileWriter.write(String.valueOf(line.getYearStart() + " "));
                fileWriter.write(String.valueOf(line.getYearEnd() + " "));
                fileWriter.write(String.valueOf(line.getYear() + "\n"));
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
