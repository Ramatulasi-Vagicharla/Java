
// Uncomment the following line when actually placing this class in another package
// package com.example.otherpackage;

import main.java.test.AccessModifiersDemo;

// Subclass in a different package
public class OtherPackageSubClass extends AccessModifiersDemo {
    public void accessMembers() {
        // Can access public and protected members of the superclass
        System.out.println("OtherPackageSubClass accessing publicVar: " + publicVar);
        System.out.println("OtherPackageSubClass accessing protectedVar: " + protectedVar);
        // Cannot access default or private members of the superclass
        // System.out.println(defaultVar);  // Compilation error
        // System.out.println(privateVar);  // Compilation error

        publicMethod();
        protectedMethod();
        // defaultMethod();  // Compilation error
        // privateMethod();  // Compilation error
    }
}