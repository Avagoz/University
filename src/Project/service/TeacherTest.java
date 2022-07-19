package Project.service;

import Project.base.Address;
import Project.model.Methodist;
import Project.model.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TeacherTest {
    List<Methodist> met;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        met = new ArrayList<>();
        met.add(new Methodist(" ", " ", " ", 0, 0, new Address("...", "...", "...", 0)));
        met.get(0).setTeachers(new ArrayList<>());
        met.get(0).getTeachers().add(new Teacher("Olya", "Teach1", "F", 10, 10));
        met.get(0).getTeachers().get(0).setAge(-10);

    }

    @org.junit.jupiter.api.Test
    void setPayday() {
//        met.add(new Methodist(" ", " ", " ", 0, 0, new Address("...", "...", "...", 0)));
        Assertions.assertTrue(met.get(0).getTeachers().get(0).getPayday()>0);
        Assertions.assertEquals(150,met.get(0).getTeachers().get(0).getPayday());

    }

    @Test
    void setAge() {
        //если возраст <0, то выдаст ошибку, и принудительно присвоит значение 0
        Assertions.assertTrue(met.get(0).getTeachers().get(0).getAge()==0);
        Assertions.assertEquals(0,met.get(0).getTeachers().get(0).getAge());



    }
}