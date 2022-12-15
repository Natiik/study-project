package org.example.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMain {

    @SneakyThrows
    public static void main(String[] args) {
        MyClass myClass = new MyClass(4, "first");
        int number = myClass.getNumber();
        String name = null;
        System.out.println(number + name);

        Field[] publicFields = myClass.getClass().getFields();
        Field[] privateAndProtectedFields = myClass.getClass().getDeclaredFields();
        Field nameField = myClass.getClass().getDeclaredField("name");
        nameField.setAccessible(true);
        name = (String) nameField.get(myClass);


        System.out.println(number + name);


        String classNAme = MyClass.class.getName();
        Class<?> clazz = Class.forName(classNAme);
        Class<?>[] classes = {int.class, String.class};
        myClass = (MyClass) clazz.getDeclaredConstructor(classes).newInstance(3, "second");
        printData(myClass);
    }

    public static void printData(Object myClass) {
        try {
            Method printData = myClass.getClass().getDeclaredMethod("printData");
            printData.setAccessible(true);
            printData.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            System.out.print("Error " + e.getClass());
        }
    }
}
