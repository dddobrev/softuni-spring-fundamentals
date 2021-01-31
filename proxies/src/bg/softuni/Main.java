package bg.softuni;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        StudentServiceIfc studentServiceIfc =
            (StudentServiceIfc) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[] {StudentServiceIfc.class},
                new CacheableInvocationHandler(new StudentServiceImpl())
            );

        studentServiceIfc.getAllStudents();
        studentServiceIfc.getAllStudents();

    }
}
