package Project.util;

import Project.model.Methodist;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MethodistListSave {
    public void methodistListSave(List<Methodist> met) throws IOException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("MethodistList.txt");
            for (Methodist s : met) {
                fileWriter.write(String.valueOf(s.getName()) + " ");
                fileWriter.write(String.valueOf(s.getSurname() + " "));
                fileWriter.write(String.valueOf(s.getGender() + " "));
                fileWriter.write(String.valueOf(s.getAge() + " "));
                fileWriter.write(String.valueOf(s.getPayday() + " "));
                fileWriter.write(String.valueOf(s.getAddress().getCity() + " "));
                fileWriter.write(String.valueOf(s.getAddress().getStreet() + " "));
                fileWriter.write(String.valueOf(s.getAddress().getHome() + " "));
                fileWriter.write(String.valueOf(s.getAddress().getApt() + "\n"));
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
