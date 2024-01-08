package org.jaeyeal.lab.app.lab.java;

import org.apache.commons.lang3.StringUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternLab {
    public static void main(String[] args) {
        Path basePath = Paths.get("\\\\192.168.1.224\\Zone_hyoworld\\jy\\multi-sample-9\\smp2\\img3");
        Path pathInfo = Paths.get("\\\\192.168.1.224\\Zone_hyoworld\\jy\\multi-sample-9\\smp2\\img3");

        Pattern pattern = Pattern.compile("[`!@$%^*=+|:;'\"<>?,]");

        String baseCheckPathStr = basePath.getFileName().toString();
        System.out.println("baseCheckPathStr = " + baseCheckPathStr);
        String basePathStr = basePath.toString();
        System.out.println("basePathStr = " + basePathStr);
        String checkPathStr = StringUtils.replace(pathInfo.toString(), basePathStr, "");
        System.out.println("checkPathStr = " + checkPathStr);

        Matcher matcher = pattern.matcher(baseCheckPathStr);
        System.out.println("matcher = " + matcher);
        boolean baseCheckPathFind = matcher.find();
        System.out.println("baseCheckPathFind = " + baseCheckPathFind);

        Matcher matcher1 = pattern.matcher(checkPathStr);
        System.out.println("matcher1 = " + matcher1);
        boolean checkPathFind = matcher1.find();
        System.out.println("checkPathFind = " + checkPathFind);


    }
}
