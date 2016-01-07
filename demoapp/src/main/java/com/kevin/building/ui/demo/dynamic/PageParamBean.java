package com.kevin.building.ui.demo.dynamic;

import com.kevin.building.ui.demo.dynamic.view.viewbean.ViewBean;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/28 14:23
 */
public class PageParamBean {


   /* {
        "baseId":"683848708101509120",
            "basePackageId":"683848707761770496",
            "basePackageName":"软件园(测试超市)22",
            "collectClassId":"644017440660914176",
            "collectClassParentId":"643695198416666624",
            "dataName":"软件园(测试超市)22",
            "deviceInfo":"865410018610977",
            "deviceinfo":"865410018610977",
            "entranceStatus":"1",
            "ownerId":"3",
            "taskId":"660036016022745091",
            "userName":"a4000201",
            "versionNo":"666908636098076672"
    }*/

   /* "baseId":"683848712765571072",
            "basePackageId":"683848712450998272",
            "basePackageName":"软件园(测试商场)66",
            "collectClassId":"644038200045600768",
            "collectClassParentId":"643695219715342336",
            "dataName":"软件园(测试商场)66",
            "deviceInfo":"865410018610977",
            "deviceinfo":"865410018610977",
            "ownerId":"3",
            "taskId":"660036015817224193",
            "userName":"a4000201",
            "versionNo":"666909163636662272",
            "event":"644038200045600768_click",
            "uuid":null,
            "maxCount":"1"*/
    /**
     * 采集项目id
     */
    private String ownerId;
    /**
     * 用户名
     */
    private String userName;
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
     * 类id
     */
    private String collectClassId;
    /**
     * 父类id
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
    private String versionNO;

    /**
     * 最大采集次数
     */
    private int maxCount;

    /**
     * 界面元素列表
     */
    private List<ViewBean> viewBeanList;

}
