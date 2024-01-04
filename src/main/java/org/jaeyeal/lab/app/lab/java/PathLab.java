package org.jaeyeal.lab.app.lab.java;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathLab {
    public static void main(String[] args) {
        String basePathStr = "\\\\192.168.1.224\\Zone_hyoworld\\jy\\multi-sample-8\\smp1\\img1";
        Path basePath = Paths.get(basePathStr);
        System.out.println("basePath = " + basePath);
        System.out.println("basePath.getRoot() = " + basePath.getRoot());
        // getParent() : 현재 경로의 부모를 반환
        System.out.println("basePath.getParent() = " + basePath.getParent());
        // getFileName() : 디렉토리 계층 구조에서 루트에서 가장 멀리 떨어진 요소를 반환
        System.out.println("basePath.getFileName() = " + basePath.getFileName());
        System.out.println("basePath.getFileSystem() = " + basePath.getFileSystem());
        System.out.println("basePath.getName(0) = " + basePath.getName(0));
        System.out.println("basePath.getName(1) = " + basePath.getName(1));
        System.out.println("basePath.getNameCount() = " + basePath.getNameCount());
        for (int i =0; i < basePath.getNameCount(); i++) {
            System.out.println(i + ": "+ basePath.getName(i));
        }

        URI uri = basePath.toUri();
        Path absolutePath = basePath.toAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("uri = " + uri);

        Path normalize = basePath.normalize();
        System.out.println("normalize = " + normalize);

    }
}
