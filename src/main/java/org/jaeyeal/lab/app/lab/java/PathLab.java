package org.jaeyeal.lab.app.lab.java;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PathLab {
    public static void main(String[] args) throws IOException {
        String basePathStr = "\\\\192.168.1.224\\aistudionas\\aistudio\\kor\\hyoworld\\202401\\image";
        Path basePath = Paths.get(basePathStr);
        List<Path> collect = Files.walk(basePath).collect(Collectors.toList());
        collect.forEach(i -> System.out.println(i));
        System.out.println("=====");
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

        System.out.println("===========================================");
        String syncDirectoryPath = "\\\\192.168.1.224\\Zone_hyoworld\\jy\\multi-sample-9\\smp1\\img4";
        List<Path> smp2Img3List = Files.walk(Paths.get(syncDirectoryPath)).collect(Collectors.toList());
        smp2Img3List.forEach(i -> System.out.println(i));
//        \\192.168.1.224\Zone_hyoworld\jy\multi-sample-9\smp2\img3
//        \\192.168.1.224\Zone_hyoworld\jy\multi-sample-9\smp2\img3\20230331162202623.jpg
//        \\192.168.1.224\Zone_hyoworld\jy\multi-sample-9\smp2\img3\img3.jpg
//        \\192.168.1.224\Zone_hyoworld\jy\multi-sample-9\smp2\img3\img4.jpg
//        \\192.168.1.224\Zone_hyoworld\jy\multi-sample-9\smp2\img3\img5.jpg
//        \\192.168.1.224\Zone_hyoworld\jy\multi-sample-9\smp2\img3\img6.jpg
//        \\192.168.1.224\Zone_hyoworld\jy\multi-sample-9\smp2\img3\img7.jpg
        // 마지막 경로 부터 , 내부 파일 까지
        // 단, 이때 Files.walk()에서 maxDepth 를 설정한다면
        System.out.println("=====");
        List<Path> maxDepth1List = Files.walk(Paths.get(syncDirectoryPath), 3).filter(i -> Files.isRegularFile(i)).collect(Collectors.toList());
        maxDepth1List.forEach(i -> System.out.println(i));

    }
}
