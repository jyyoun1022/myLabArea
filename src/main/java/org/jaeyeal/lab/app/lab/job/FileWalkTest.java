package org.jaeyeal.lab.app.lab.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class FileWalkTest {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> folderMap  = new HashMap<>();
        final String companyRootPath = "\\\\192.168.1.224\\Zone_hyoworld";
        Path path = Paths.get(companyRootPath);
        System.out.println("path = " + path);
        System.out.println("path.toString() = " + path.toString());

//        Path pathTest = Paths.get("\\");
//        Files.walk(pathTest,1).collect(Collectors.toList()).stream().forEach(i -> System.out.println(i));

        /**
         * maxDepth = 0 일 때  \\192.168.1.224\Zone_hyoworld\
         *          = 1일 때, maxDepth 0일 떄 포함 하위 폴더 읽어들임
         *  - 즉 deps 만큼 탐색함
         */


        int[] iFolderIndex= {1};

        try (Stream<Path> streamResult = Files.walk(path, 1)){
            List<FolderTreeVo> folderList = streamResult
                    .filter(currPath -> Files.isDirectory(currPath))    // 폴더구조만
                    .filter(currPath -> isNotHiddenPath(currPath))  //  숨김파일이 아닌 것만
                    .filter(currPath -> checkExcludesSyncPath(companyRootPath, currPath)) // 폴더 이름이 export,import 가 아닌것
                    .sorted()   //  정렬
                    .map(currPath -> {
                        Integer folderIndex = (iFolderIndex[0]++);
                        String folderPathStr = currPath.toString();

                        FolderTreeVo folderTreeVo = new FolderTreeVo();
                        folderTreeVo.setId(folderIndex); // 1

                        if (currPath.getFileName() == null) {
                            folderTreeVo.setName("/");
                        } else {
                            folderTreeVo.setName(currPath.getFileName().toString());
                        }
//                        while (true) {
//                            log.info("CURRENT_PATH= {}", currPath);
//                            break;
//                        }
                        log.info("폴더 이름 = {}", currPath.getFileName());

                        if (iFolderIndex[0] == 2) { //CompanyRootPath index
                            folderTreeVo.setPId(0);
                            folderTreeVo.setSelfPath(folderPathStr);
                            folderTreeVo.setParentPath("");
                            folderTreeVo.setOpen(true);
                            folderTreeVo.setClick(false);
                        } else {
                            folderTreeVo.setSelfPath(folderPathStr);
                            folderTreeVo.setViewPath(StringUtils.replace(folderPathStr, companyRootPath, ""));
                            folderTreeVo.setParentPath(currPath.getParent().toString());
                            folderTreeVo.setOpen(false);
                            folderTreeVo.setClick(true);
                        }
                        folderMap.put(folderPathStr, folderIndex);
                        if (folderTreeVo.getPId() == null) {
                            Integer pid = folderMap.get(folderTreeVo.getParentPath());
                            folderTreeVo.setPId(pid);
                        }
                        return folderTreeVo;
                    })
                    .collect(Collectors.toList());

            folderList.forEach(i -> log.info(i.toString()));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BizException(e.getMessage());
        }



    }

    static class BizException extends RuntimeException {
        public BizException(String message) {
            super(message);
        }
    }
    private static boolean isNotHiddenPath(Path folderPath) {
        try {
            return !Files.isHidden(folderPath);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    private static boolean checkExcludesSyncPath(String companyRootPath, Path pathInfo) {
//        \\192.168.1.224\Zone_hyoworld\import or export 로 된다면 return false;
        boolean returnValue = true;
        String[] excludeSyncFolderArr = {"export", "import"};
        for (String excludeSyncFolder : excludeSyncFolderArr) {
            String compareTargetStr = companyRootPath + File.separator + excludeSyncFolder;
            if (pathInfo.toString().startsWith(compareTargetStr)) {
//                System.out.println("compareTargetStr = " + compareTargetStr);
//                System.out.println("pathInfo = " + pathInfo);
                returnValue = false;
                break;
            }
        }
//        log.info("checkExcludePath = {}", returnValue);
        return returnValue;
    }



}
