package com.kevin.building.demo.dynamic.view.impl.group;

import com.kevin.building.base.BaseActivity;
import com.kevin.building.demo.dynamic.DetailActivity;
import com.kevin.building.demo.dynamic.adapter.AbsBaseBtnGroupAdapter;
import com.kevin.building.demo.dynamic.adapter.BtnPhotoGroupAdapter;
import com.kevin.building.demo.dynamic.bean.viewbean.base.BaseItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.demo.dynamic.callback.MyOnClickListener;
import com.kevin.building.demo.dynamic.view.base.BaseGridViewNew;
import com.kevin.building.utils.ActivityUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/28 15:52
 */
public class PhotoBtnGridView extends BaseGridViewNew {


    public PhotoBtnGridView(BaseActivity baseActivity, BaseItem baseItem) {
        super(baseActivity, baseItem);
    }


    @Override
    protected MyOnClickListener getOnClickCallback(final BaseActivity baseActivity, final List<BtnItem> btnItemList) {
        return new MyOnClickListener() {
            @Override
            public void onClick(int position) {
                BtnItem item = btnItemList.get(position);
                HashMap<String, String> paramMap = new HashMap<>();
                paramMap.put("name", item.getIndexText());
                ActivityUtils.startActivity(baseActivity, DetailActivity.class, paramMap);

            }
        };
    }

    @Override
    protected AbsBaseBtnGroupAdapter getAdapter(BaseActivity baseActivity, List<BtnItem> btnItemList) {
        return new BtnPhotoGroupAdapter(baseActivity, btnItemList);
    }
}
