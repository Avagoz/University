package Project.util;

import Project.model.Group;

import java.util.Comparator;

public class EndComporator implements Comparator<Group> {
    @Override
    public int compare(Group o1, Group o2) {
        if (o1.getYearEnd() - o2.getYearEnd() == 0) {
            if (o1.getGroup() - o2.getGroup() == 0) {
                if (o1.getYear() - o2.getYear() == 0) {
                    return o1.getYearStart() - o2.getYearStart();
                }
                return o1.getYear() - o2.getYear();
            }
            return o1.getGroup() - o2.getGroup();
        }
        return o1.getYearEnd() - o2.getYearEnd();
    }
}
