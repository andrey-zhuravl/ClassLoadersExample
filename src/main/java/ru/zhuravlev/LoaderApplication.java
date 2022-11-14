package ru.zhuravlev;

import ru.zhuravlev.andrey.CustomClassLoader1;
import ru.zhuravlev.kirill.CustomClassLoader2;
import ru.zhuravlev.loading.MyClass1;
import ru.zhuravlev.loading.MyInterface;
import ru.zhuravl.ZhuravlevAndrey;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class LoaderApplication {
    static {
        System.out.println("Start LoaderApplication");
    }
    public static void main(String[] args) throws IOException {


        ZhuravlevAndrey zhuravlevAndrey = new ZhuravlevAndrey();
        zhuravlevAndrey.getName();
        CustomClassLoader1 customClassLoader1 = new CustomClassLoader1();
        CustomClassLoader2 customClassLoader2 = new CustomClassLoader2();
        MyClass1 c = new MyClass1();
        try {
            Class obj1;
            obj1 = customClassLoader1.findClass("org.zhuravlev.loading.MyClass1");
            Object myClass1AndreyObject = obj1.getConstructor().newInstance();
            Object myClass1AndreyObject1 = obj1.getConstructor(String.class).newInstance("Andrey1");
            ((MyInterface) myClass1AndreyObject1).print();

            Object obj2;
            obj2 = customClassLoader2.findClass("org.zhuravlev.loading1.MyClass1").newInstance();
            Object myClass1KirillObject = obj2.getClass().newInstance();
            Object myClass1KirillObject1 = obj2.getClass().getConstructor(String.class).newInstance("Kirill1");
            ((MyInterface) myClass1KirillObject1).print();

        } catch (ClassFormatError e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
