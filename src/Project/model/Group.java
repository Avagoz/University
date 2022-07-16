package Project.model;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private int group;
    private int year;



    private int razmer;
    private int yearStart;
    private int yearEnd;
    private List<Student> stud;

    public Group() {

    }

    public Group(int group, int yearStart, int yearEnd, int year, int razmer) {
        this.group = group;
        this.yearStart=yearStart;
        this.yearEnd=yearEnd;
        this.year = year;
        this.razmer = razmer;
        this.stud = new ArrayList<>();
        for (int i = 0; i < razmer; i++) {
            stud.add(new Student("..."+i, "...","...", 19));

        }
    }

    public List<Student> getStud() {
        return this.stud;
    }

    public void setStud(List<Student> stud) {
        this.stud = stud;
    }

    public int getYearStart() {
        return yearStart;
    }

    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }

    public int getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(int yearEnd) {
        this.yearEnd = yearEnd;
    }

    public int getRazmer() {
        return this.razmer;
    }

    public void setRazmer(int razmer) {
        this.razmer = razmer;
    }

    public int getGroup() {
        return this.group;
    }

    public void setGroup(int group) {
        this.group=group;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
//-------------Метод добавления ученика и его адреса-----------------------------------------------

    public void addStud() {
        stud.add(new Student(stud.get(stud.size() - 1).getName(),
                             stud.get(stud.size() - 1).getSurname(),
                             stud.get(stud.size() - 1).getGender(),
                             stud.get(stud.size() - 1).getAge()));
    }

//-------------Метод удааления ученика и его адреса-------------------------------------------------

    public List<Student> deleteStud(int d) {
        getStud().remove(d);
        return getStud();
    }


    @Override
    public String toString() {
        return "\n\n==============" +
                "\nGroup: " + getGroup() +
                "\n==============" +
                "\nYear: " + getYear() +
                "\n=============="+
                "\n yearStart=" + getYearStart() +
                "\n yearEnd=" + getYearEnd() +
                "\n"+  getStud().toString();

    }
}
