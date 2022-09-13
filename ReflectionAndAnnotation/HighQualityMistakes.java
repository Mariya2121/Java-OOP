package ReflectionAndAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.TreeSet;

public class HighQualityMistakes {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();
        Field[] declaredFields = clazz.getDeclaredFields();

        TreeSet<Method> getters = ReflectionUtils.collectByName(ReflectionUtils.filterMembersByName(methods, "get"));
        TreeSet<Method> setters = ReflectionUtils.collectByName(ReflectionUtils.filterMembersByName(methods, "set"));

        TreeSet<Field> fields = ReflectionUtils.collectByName(Arrays.stream(declaredFields));


        fields.stream().filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        getters.stream().filter(g -> !Modifier.isPublic(g.getModifiers()))
                .forEach(g -> System.out.println(g.getName() + " have to be public!"));

        setters.stream().filter(s -> !Modifier.isPrivate(s.getModifiers()))
                .forEach(s -> System.out.println(s.getName() + " have to be private!"));
    }
}
