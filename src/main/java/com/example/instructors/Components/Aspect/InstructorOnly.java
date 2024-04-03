package com.example.instructors.Components.Aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Adnotacja może być stosowana tylko do metod
@Retention(RetentionPolicy.RUNTIME) // Adnotacja dostępna w czasie działania programu
public @interface InstructorOnly {
}
