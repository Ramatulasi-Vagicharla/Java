

import main.java.test.AccessModifiersDemo;

// Class in a different package
public class OtherPackageClass {
    public void accessMembers() {
        AccessModifiersDemo demo = new AccessModifiersDemo();
        // Can only access public members
        System.out.println("OtherPackageClass accessing publicVar: " + demo.publicVar);
        // Cannot access protected, default, or private members
        // System.out.println(demo.protectedVar); // Compilation error
        // System.out.println(demo.defaultVar);   // Compilation error
        // System.out.println(demo.privateVar);   // Compilation error

        demo.publicMethod();
        // demo.protectedMethod(); // Compilation error
        // demo.defaultMethod();   // Compilation error
        // demo.privateMethod();   // Compilation error
    }
}