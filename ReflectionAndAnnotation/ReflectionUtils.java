package ReflectionAndAnnotation;

import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionUtils {

    private ReflectionUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Accessing this constructor is forbidden");
    }

    public static <T extends Member> Stream<T> filterMembersByName(T[] members, String filter) {
        return Arrays.stream(members)
                .filter(m -> m.getName().contains(filter));
    }

    public static <T extends  Member> TreeSet<T> collectByName(Stream<T> stream){
          return stream.collect(Collectors.toCollection(
                () -> new TreeSet<>(Comparator.comparing(Member::getName))));
    }
}
