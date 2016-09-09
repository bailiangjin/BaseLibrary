package com.kevin.building.demo.dynamic.view.base;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.kevin.building.R;
import com.kevin.building.demo.dynamic.adapter.AbsBaseBtnGroupAdapter;
import com.kevin.building.demo.dynamic.bean.viewbean.base.BaseItem;
import com.kevin.building.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.demo.dynamic.callback.MyOnClickListener;
import com.kevin.building.demo.dynamic.view.root.BaseView;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/28 15:50
 */
public abstract class BaseGridViewNew extends BaseView {

    private GridView gv_container;
    private BtnGroup btnGroup;


    //    public BaseGridViewNew(Context context, BaseItem baseItem) {
//        super(context, baseItem);
//    }
    public BaseGridViewNew(Activity baseActivity, BaseItem baseItem) {
        super(baseActivity, baseItem);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.ctn_gridview;
    }

    @Override
    protected void initBase(BaseItem baseItem) {
        btnGroup = (BtnGroup) baseItem;
    }

    @Override
    protected void initView() {
        gv_container = (GridView) findViewById(R.id.gv_container);

        final MyOnClickListener onClickListener = getOnClickCallback(baseActivity, btnGroup.getBtnList());
        gv_container.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onClickListener.onClick(position);
            }
        });

        gv_container.setAdapter(getAdapter(baseActivity, btnGroup.getBtnList()));
    }

    @Override
    protected void initLogic() {

    }

    /**
     *   获取点击事件回调
     * @param baseActivity
     * @param btnItemList
     * @return
     */
    protected abstract MyOnClickListener getOnClickCallback(Activity baseActivity, List<BtnItem> btnItemList);

    /**
     *  获取GridView Adapter适配器
     * @param baseActivity
     * @param btnItemList
     * @return
     */
    protected abstract AbsBaseBtnGroupAdapter getAdapter(Activity baseActivity, List<BtnItem> btnItemList);
}
