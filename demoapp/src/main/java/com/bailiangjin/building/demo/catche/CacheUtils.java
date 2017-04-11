package com.bailiangjin.building.demo.catche;

import com.bailiangjin.utilslibrary.utils.app.AppUtils;
import com.bailiangjin.utilslibrary.utils.file.SerializeTools;
import com.bailiangjin.building.model.TaskItemBean;

/**
 * 封装的缓存类 可在此处添加其他数据缓存方法
 * Created by bailiangjin on 16/3/25.
 */
public class CacheUtils {

    public static final String DEMO_CATCH_FILE = "home_page_file";


    /**
     * 缓存数据
     * @param taskItemBean
     * @return
     */
    public static boolean cacheData(TaskItemBean taskItemBean){
        return SerializeTools.cacheObj(AppUtils.getContext(), DEMO_CATCH_FILE,taskItemBean);
    }

    /**
     * 从缓存中获取 缓存数据
     * @return
     */
    public static TaskItemBean getCacheData(){
        return SerializeTools.getObj(AppUtils.getContext(), DEMO_CATCH_FILE, TaskItemBean.class);
    }


}
