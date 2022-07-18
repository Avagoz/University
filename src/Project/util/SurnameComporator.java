package Project.util;

import Project.base.People;

import java.util.Comparator;

public class SurnameComporator implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        if (o1.getSurname().compareTo(o2.getSurname()) == 0) {
            if (o1.getName().compareTo(o2.getName()) == 0) {
                if (o1.getAge() - o2.getAge() == 0) {
                    return o1.getGender().compareTo(o2.getGender());
                }
                return o1.getAge() - o2.getAge();
            }
            return o1.getName().compareTo(o2.getName());
        }
        return o1.getSurname().compareTo(o2.getSurname());
    }


}
