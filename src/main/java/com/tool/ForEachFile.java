package com.tool;
/**

* @Description:遍历文件夹处理bom头

* @UpdateRemark:

* @Author:         yuxiao

* @CreateDate:     2018/11/16 13:34

* @UpdateUser:     yuxiao

* @UpdateDate:     2018/11/16 13:34

* @Version:        云平台

*/

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ForEachFile {
    HashSet<File> filesSet = new HashSet<>();
    public Set<File> getForEachFile(File file){
        File[] files = file.listFiles();
        for(File fileInFile:files){
            boolean directory = fileInFile.isDirectory();
            if (directory == true){
                this.getForEachFile(fileInFile);
            }else{
                filesSet.add(fileInFile);
            }
        }
        return filesSet;
    }
}
