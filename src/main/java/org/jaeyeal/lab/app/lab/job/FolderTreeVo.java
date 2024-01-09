package org.jaeyeal.lab.app.lab.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FolderTreeVo {

    private Integer id;
    private Integer pId;
    private String  name;
    private String  title;
    private String  selfPath;
    private String  viewPath;
    private String  parentPath;
    private Boolean isParent;
    private Boolean open;
    private Boolean click;
    private Boolean checked;

    private Boolean isDirectory;

    private String  projectId;
    private String  companyCode;
    private String  orgnFilePath;
    private Integer level;
    private Integer dataCnt;
    private Integer dataSize;

//    public void setIsParent(boolean b) {
//        this.isParent = b;
//    }
//
//    public boolean getIsParent() {
//        return this.isParent;
//    }
//
//    public void setpId(int i) {
//        this.pId = i;
//    }
//
//    public Integer getpId() {
//        return this.pId;
//    }
}