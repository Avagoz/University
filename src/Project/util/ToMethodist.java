package Project.util;

@FunctionalInterface
public interface ToMethodist<Methodist, Teacher> {
    Methodist convert(Teacher value);
}
