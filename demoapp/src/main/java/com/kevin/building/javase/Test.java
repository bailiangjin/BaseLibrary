package com.kevin.building.javase;

import com.kevin.baselibrary.utils.GsonUtils;
import com.kevin.baselibrary.utils.PinyinUtils;
import com.kevin.building.ui.demo.dynamic.view.viewbean.ViewBean;
import com.kevin.building.ui.demo.dynamic.view.viewbean.constants.ItemType;
import com.kevin.building.ui.demo.dynamic.view.viewbean.group.BtnGroup;
import com.kevin.building.ui.demo.dynamic.view.viewbean.group.CBGroup;
import com.kevin.building.ui.demo.dynamic.view.viewbean.group.RBGroup;
import com.kevin.building.ui.demo.dynamic.view.viewbean.item.BtnItem;
import com.kevin.building.ui.demo.dynamic.view.viewbean.item.EditTextItem;
import com.kevin.building.ui.demo.dynamic.view.viewbean.item.TextItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/10 18:36
 */
public class Test {

    public static void main(String[] args) {
        testPinyin();
        testTimes(5);

        testJson();
    }

    private static void testJson() {
        List<ViewBean> list = new ArrayList<>();
        ViewBean viewBean = null;

        for (int i = 0; i < 10; i++) {
            viewBean = new ViewBean();
            int type = i % 6;
            viewBean.setItemType(type);
            switch (type) {
                case ItemType.TEXT:
                   TextItem textItem =  new TextItem();
                    viewBean.setTextItem(textItem);
                    break;
                case ItemType.ET:
                    viewBean.setEditTextItem(new EditTextItem());
                    break;
                case ItemType.BTN:
                    viewBean.setBtnItem(new BtnItem());
                    break;
                case ItemType.BTN_GROUP:
                    BtnGroup btnGroup = new BtnGroup();

                    List<BtnItem> btnItemList =new ArrayList<>();
                    btnItemList.add(new BtnItem());
                    btnItemList.add(new BtnItem());
                    btnItemList.add(new BtnItem());
                    btnItemList.add(new BtnItem());
                    btnGroup.setBtnList(btnItemList);
                    viewBean.setBtnGroup(btnGroup);
                    break;
                case ItemType.RB_GROUP:
                    viewBean.setRbGroup(new RBGroup());
                    break;
                case ItemType.CB_GROUP:
                    viewBean.setCbGroup(new CBGroup());
                    break;

                default:
                    break;

            }

            list.add(viewBean);
        }

       String json=  GsonUtils.getInstance().toJson(list);

        System.out.println(json);
    }

    private static void testPinyin() {
        System.out.println("转换结果:" + PinyinUtils.chinese2Pinyin("中国好声音"));
    }

    private static void testTimes(int n) {
        int i = 1;
        int j = n;
        int x = 0;

        while (i < j) {
            System.out.println("i=" + i + " j=" + j + " x=" + x);
            i++;
            j--;
            x += 2;

        }

        System.out.println("x=" + x);

    }
}
