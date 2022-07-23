package Project.util;

import Project.model.Group;
import Project.model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentListSave {
    public  void studentListSave( List<Group> groups) throws IOException {


        FileWriter fileWriter = null;


        try {
            fileWriter = new FileWriter("StudentList.txt");
            for (Group a : groups) {
                for (Student s : a.getStud()) {

                    fileWriter.write(String.valueOf(s.getName()) + " ");
                    fileWriter.write(String.valueOf(s.getSurname() + " "));
                    fileWriter.write(String.valueOf(s.getGender() + " "));
                    fileWriter.write(String.valueOf(s.getAge() + " "));
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
            if (fileWriter!= null){
                fileWriter.close();
            }
        }
    }

}
