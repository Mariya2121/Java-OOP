package ReflectionAndAnnotation;

import java.lang.reflect.Method;
import java.util.TreeSet;
import java.util.function.Function;

public class GettersAndSetters {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        TreeSet<Method> getters = ReflectionUtils.collectByName(ReflectionUtils.filterMembersByName(methods, "get"));

        TreeSet<Method> setters = ReflectionUtils.collectByName(ReflectionUtils.filterMembersByName(methods, "set"));

        Function<Class<?>, String> formatType = c -> c == int.class ? "class int" : c.toString();

        getters.forEach(getter -> System.out.printf("%s will return %s%n", getter.getName(), formatType.apply(getter.getReturnType())));

        setters.forEach(setter -> System.out.printf("%s and will set field of %s%n", setter.getName(), formatType.apply(setter.getParameterTypes()[0])));
    }

}
