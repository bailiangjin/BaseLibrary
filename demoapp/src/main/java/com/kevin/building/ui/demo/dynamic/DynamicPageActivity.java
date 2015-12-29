package com.kevin.building.ui.demo.dynamic;

import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

import java.util.ArrayList;
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

    private  LayoutInflater layoutInflater;


    @Override
    protected int getLayoutResId() {
        return -1;
    }

    @Override
    protected void initView() {

        layoutInflater = LayoutInflater.from(this);

        // 创建LinearLayout对象
        LinearLayout mLinearLayout = (LinearLayout) layoutInflater.inflate(R.layout.ctn_ll,null);


        setContentView(mLinearLayout);

        // 创建TextView对象
        TextView mTextView = (TextView) layoutInflater.inflate(R.layout.ctn_textview,null);
        // 设置文字
        mTextView.setText("hello world");
        mTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        // 在父类布局中添加它，及布局样式
        mLinearLayout.addView(mTextView);

        gv_essential = (GridView) layoutInflater.inflate(R.layout.ctn_gridview, null);
        mLinearLayout.addView(gv_essential);

        initData();

        gv_essential.setAdapter(new EssentialAdapter(DynamicPageActivity.this, essentialItemList));
    }

    private void initData() {
        essentialItemList.clear();

        for (int i = 0; i < 4; i++) {
            EssentialItem essentialItem = new EssentialItem();
            essentialItem.setItemType(ItemType.BUTTON);
            essentialItem.setTxtName("按钮" + (i + 1));
            essentialItemList.add(essentialItem);
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
