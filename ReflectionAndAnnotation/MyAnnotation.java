package ReflectionAndAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)// Къде ще се изпълнява анотацията(по време на изпълнението на програмата)
@Target(ElementType.PARAMETER)// Къде може да се постави тази анотация
public @interface MyAnnotation {

    String name();

}

