package Project.test;

import Project.model.Address;
import Project.model.Group;
import Project.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GroupTestAddDeleteStudent {
    ArrayList<Group> groups;
    @BeforeEach
    void setUp() {
        groups = new ArrayList<>();
        groups.add(new Group(0, 0, 0, 0));
        groups.get(0).getStud().add(new Student("...", "...", "...", 0,new Address("...", "...", "...", 0)));            //то условие создает новый массив
        groups.get(0).addStud();
        groups.get(0).addStud();
        groups.get(0).addStud();
        groups.get(0).addStud();
        groups.get(0).addStud();


    }

    @Test
    void addStud() {
        // добавили метоодом addStud, 1+5=6
        Assertions.assertTrue(groups.get(0).getStud().size()>5);
        Assertions.assertEquals(6,groups.get(0).getStud().size());
    }

    @Test
    void deleteStud() {
        // удалили трех студентов методом,6-3=3
        groups.get(0).deleteStud(5);
        groups.get(0).deleteStud(3);
        groups.get(0).deleteStud(0);
        Assertions.assertTrue(groups.get(0).getStud().size()>2);
        Assertions.assertEquals(3,groups.get(0).getStud().size());

    }
}