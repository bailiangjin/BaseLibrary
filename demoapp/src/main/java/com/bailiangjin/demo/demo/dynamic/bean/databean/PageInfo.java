package com.bailiangjin.demo.demo.dynamic.bean.databean;

/**
 * 页面基本信息Bean
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/19 10:32
 */
public class PageInfo {

    /**
     * 采集项目id
     */
    private String ownerId;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 页面标题
     */
    private String title;
    /**
     * 手机设备信息
     */
    private String deviceInfo;

    /**
     * 类id
     */
    private String baseId;
    /**
     * 包id
     */
    private String basePackageId;
    /**
     * 包名
     */
    private String basePackageName;
    /**
     * 采集项名称
     */
    private String dataName;
    /**
     * 当前采集小类id
     */
    private String collectClassId;
    /**
     * 采集大类id
     */
    private String collectClassParentId;

    /**
     * 任务id
     */
    private String taskId;

    /**
     * 是否为主页
     */
    private String entranceStatus;

    /**
     * 版本号
     */
    private String versionNo;

    /**
     * 最大采集次数
     */
    private int maxCount;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getBasePackageId() {
        return basePackageId;
    }

    public void setBasePackageId(String basePackageId) {
        this.basePackageId = basePackageId;
    }

    public String getBasePackageName() {
        return basePackageName;
    }

    public void setBasePackageName(String basePackageName) {
        this.basePackageName = basePackageName;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getCollectClassId() {
        return collectClassId;
    }

    public void setCollectClassId(String collectClassId) {
        this.collectClassId = collectClassId;
    }

    public String getCollectClassParentId() {
        return collectClassParentId;
    }

    public void setCollectClassParentId(String collectClassParentId) {
        this.collectClassParentId = collectClassParentId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getEntranceStatus() {
        return entranceStatus;
    }

    public void setEntranceStatus(String entranceStatus) {
        this.entranceStatus = entranceStatus;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
