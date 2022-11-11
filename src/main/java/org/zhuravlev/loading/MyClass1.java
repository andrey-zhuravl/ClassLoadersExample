package org.zhuravlev.loading;

public class MyClass1 implements MyInterface{
    String name;

    public MyClass1 () {

    }

    public MyClass1 (String name) {
        this.name = name;
    }

    static {
        printStatic();
    }

    public static void printStatic () {
        System.out.println("====================");
        System.out.println("ClassLoader name =" + MyClass1.class.getClassLoader());
        System.out.println("getPackageName name =" + MyClass1.class.getPackageName());
        System.out.println("getCanonicalName name =" + MyClass1.class.getCanonicalName());
        System.out.println("getName name =" + MyClass1.class.getName());
        System.out.println("");
    }

    public void print () {
        System.out.println("====================");
        System.out.println("name=" + name);
    }
}
