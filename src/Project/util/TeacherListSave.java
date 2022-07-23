package Project.util;

import Project.model.Methodist;
import Project.model.Teacher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TeacherListSave {
    public void teacherListSave(List<Methodist> met) throws IOException {


        FileWriter fileWriter = null;


        try {
            fileWriter = new FileWriter("TeacherList.txt");
            for (Methodist a : met) {
                for (Teacher s : a.getTeachers()) {
                    fileWriter.write(String.valueOf(s.getName()) + " ");
                    fileWriter.write(String.valueOf(s.getSurname() + " "));
                    fileWriter.write(String.valueOf(s.getGender() + " "));
                    fileWriter.write(String.valueOf(s.getAge() + " "));
                    fileWriter.write(String.valueOf(s.getPayday() / 15 + " "));
                    fileWriter.write(String.valueOf(s.getAddress().getCity() + " "));
                    fileWriter.write(String.valueOf(s.getAddress().getStreet() + " "));
                    fileWriter.write(String.valueOf(s.getAddress().getHome() + " "));
                    fileWriter.write(String.valueOf(s.getAddress().getApt() + "\n"));
                }
                fileWriter.write("/\n");
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
