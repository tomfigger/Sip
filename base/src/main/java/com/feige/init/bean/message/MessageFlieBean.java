package com.feige.init.bean.message;

/**
 * MrLiu253@163.com
 *
 * @time 2/9/22
 * 描述:
 */
public class MessageFlieBean extends MessageBean {

    private String fileName;
    private String fileSize;
    private String fileType;


    public MessageFlieBean() {
    }

    public String getFileName() {
        return fileName == null ? "" : fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize == null ? "" : fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType == null ? "" : fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
