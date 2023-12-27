package org.jaeyeal.lab.app.lab;

import java.io.File;

public class PrintLab {
    public static void main(String[] args) {
        String separator = File.separator;
        char separatorChar = File.separatorChar;
        String pathSeparator = File.pathSeparator;
        System.out.println("separator = " + separator);
        System.out.println("separatorChar = " + separatorChar);
        System.out.println("pathSeparator = " + pathSeparator);
    }
}
