package com.kevin.building.ui.demo.dynamic;

import android.os.Message;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.ui.demo.dynamic.bean.EssentialItem;
import com.kevin.building.ui.demo.dynamic.bean.IndexPageDataBean;
import com.kevin.building.ui.demo.dynamic.enumtype.ItemType;
import com.kevin.building.ui.demo.dynamic.view.BaseTextView;
import com.kevin.building.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 动态加载UIActivity
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/28 14:21
 */
public class DynamicPageActivity extends BaseActivity {

    private GridView gv_essential;
    private GridView gv_inessential;

    private EssentialAdapter essentialAdapter;

    private List<EssentialItem> essentialItemList = new ArrayList<>();
    private List<EssentialItem> inessentialItemList = new ArrayList<>();

    private LayoutInflater layoutInflater;


    @Override
    protected int getLayoutResId() {
        return -1;
    }

    @Override
    protected void initView() {
        layoutInflater = LayoutInflater.from(this);
        // 创建LinearLayout 作为根View
        LinearLayout mLinearLayout = (LinearLayout) layoutInflater.inflate(R.layout.ctn_ll, null);
        setContentView(mLinearLayout);

        BaseTextView tv_must = DynamicViewGenerater.getTitleTextView(this, "必拍");
        BaseTextView tv_not_must = DynamicViewGenerater.getTitleTextView(this, "非必拍");
        initData();

        IndexPageDataBean bean = new IndexPageDataBean();
        bean.setEssentialList(essentialItemList);
        bean.setInessentialList(inessentialItemList);

        bean.setEsTitle("必拍");
        bean.setEsTitle("非必拍");

        ClickCallback esCallback = getClickCallback(this,essentialItemList);
        ClickCallback inesCallback = getClickCallback(this,inessentialItemList);

        gv_essential = DynamicViewGenerater.getGridView(this,esCallback);
        gv_inessential = DynamicViewGenerater.getGridView(this,inesCallback);


        // 在父类布局中添加它，及布局样式
        mLinearLayout.addView(tv_must);
        mLinearLayout.addView(gv_essential);
        mLinearLayout.addView(tv_not_must);

        mLinearLayout.addView(gv_inessential);
        gv_essential.setAdapter(new EssentialAdapter(DynamicPageActivity.this, essentialItemList));
        gv_inessential.setAdapter(new EssentialAdapter(DynamicPageActivity.this, inessentialItemList));


    }

    @NonNull
    private ClickCallback getClickCallback(final BaseActivity activity,final List<EssentialItem> list) {
        return new ClickCallback() {
                @Override
                public void onClick(int position) {
                   EssentialItem item = list.get(position);
                    HashMap<String,String> paramMap = new HashMap<>();
                    paramMap.put("name",item.getTxtName());
                    ActivityUtils.startActivity(activity, DetailActivity.class,paramMap);

                }
            };
    }

    private void initData() {
        essentialItemList.clear();

        for (int i = 0; i < 4; i++) {
            EssentialItem essentialItem = new EssentialItem();
            essentialItem.setItemType(ItemType.BUTTON);
            essentialItem.setTxtName("必拍" + (i + 1));
            essentialItemList.add(essentialItem);
        }
        inessentialItemList.clear();
        for (int i = 0; i < 7; i++) {
            EssentialItem essentialItem = new EssentialItem();
            essentialItem.setItemType(ItemType.BUTTON);
            essentialItem.setTxtName("非必拍" + (i + 1));
            inessentialItemList.add(essentialItem);
        }
    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void onViewClick(View v) {

    }

    @Override
    protected void handleMsg(Message msg) {

    }
}
