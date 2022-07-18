package Project.util;

import Project.base.Personal;

import java.util.Comparator;

public class PaydayComporator implements Comparator<Personal> {
    @Override
    public int compare(Personal o1, Personal o2) {
        return o1.getPayday()- o2.getPayday();
    }
}
