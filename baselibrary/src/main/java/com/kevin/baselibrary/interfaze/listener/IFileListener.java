package com.kevin.baselibrary.interfaze.listener;

/**
 * Created by bailiangjin on 16/4/5.
 */
public interface IFileListener {

    /**
     * 新建文件
     *
     * @param filePath
     *            返回参数
     */
    public void onCreate(final String filePath);

    /**
     * 新建文件
     *
     * @param filePath
     *            返回参数
     */
    public void onModify(final String filePath);

    /**
     * 删除
     *
     * @param filePath
     *            返回参数
     */
    public void onDelete(final String filePath);

    /**
     * 读文件
     *
     * @param filePath
     *            返回参数
     */
    public void onRead(final String filePath);

    /**
     * 写文件
     *
     * @param filePath
     *            返回参数
     */
    public void onWrite(final String filePath);

    /**
     * 打开文件
     *
     * @param filePath
     *            返回参数
     */
    public void onOpen(final String filePath);

    /**
     * 关闭文件for写文件
     *
     * @param filePath
     *            返回参数
     */
    public void onCloseWrite(final String filePath);

    /**
     * 关闭文件 非写文件
     *
     * @param filePath
     *            返回参数
     */
    public void onCloseNoWrite(final String filePath);






}
