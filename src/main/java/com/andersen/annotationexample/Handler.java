package com.andersen.annotationexample;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Handler {
    public static void handle(Object o) {
        Class tempClass = o.getClass();

        for (Method m : tempClass.getMethods()) {
            for (Annotation a : m.getAnnotations()) {
                if (a instanceof MethodTrace) {
                    MethodTrace trace = (MethodTrace) a;
                    switch (trace.logLevel()) {
                        case INFO:
                            System.out.println(" Performing INFO log for \"" + m.getName() + "\" method: ");
                            System.out.println("#parameters type for  \"" + m.getName() + "\"-method: ");
                            Arrays.stream(m.getParameters()).forEach(num -> System.out.println(num));
                            System.out.println("#return type for  \"" + m.getName() + "\"-method: " + m.getReturnType());

                            break;
                        case DEBUG:
                            System.out.println("performing DEBUG log for \"" + m.getName() + "\" method");
                            break;
                    }
                }
            }
        }
    }
}
