package com.bailiangjin.demo.demo.file;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bailiangjin.demo.R;
import com.bailiangjin.demo.base.BaseActivity;
import com.bailiangjin.javabaselib.utils.FileUtils;
import com.bailiangjin.utilslibrary.utils.file.FilePathUtils;
import com.bailiangjin.utilslibrary.utils.ui.TVUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * TODD:添加类注释
 *
 * @author bailiangjin
 * @date 2017/11/14
 */

public class FileOperationActivity extends BaseActivity {

    @BindView(R.id.btn_clear_im_download_file)
    Button btn_clear_im_download_file;
    @BindView(R.id.btn_clear_photo_file)
    Button btn_clear_photo_file;
    @BindView(R.id.tv_demo)
    TextView tv_demo;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_file_operation;
    }

    @Override
    protected void beforeViewBind(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
//        String html="<html><head><title>TextView使用HTML</title></head><body><p><strong>强调</strong></p><p><em>斜体</em></p>"
//                +"<p><a href=\"http://www.dreamdu.com/xhtml/\">超链接HTML入门</a>学习HTML!</p><p><font color=\"#aabb00\">颜色1"
//                +"</p><p><font color=\"#00bbaa\">颜色2</p><h1>标题1</h1><h3>标题2</h3><h6>标题3</h6><p>大于>小于<</p><p>" +
//                "下面是网络图片</p><img src=\"http://avatar.csdn.net/0/3/8/2_zhang957411207.jpg\"/></body></html>";

        String html = "测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择" +
                "测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择测试选择";

        TVUtils.setTvWithHtmlContent(tv_demo, html, new Handler());
//        tv_demo.setTextIsSelectable(true);
//        tv_demo.setSelectAllOnFocus(true);


    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick({R.id.btn_clear_im_download_file, R.id.btn_clear_photo_file})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_clear_im_download_file:

                String gomeDownloadFileDir = FilePathUtils.getSdcardPath() + File.separator + "GoMeConnect/GoMeDownLoad";
                boolean isSuccess = FileUtils.deleteFile(gomeDownloadFileDir);
                shortToast("清理文件GoMe下载文件" + (isSuccess ? "成功" : "失败"));

                tv_demo.setTextIsSelectable(true);
                tv_demo.setSelectAllOnFocus(true);
                tv_demo.performLongClick();
//                tv_demo.performContextClick();
//                tv_demo.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
//                    @Override
//                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//                        return false;
//                    }
//
//                    @Override
//                    public void onDestroyActionMode(ActionMode mode) {
//
//                    }
//                });


                break;

            case R.id.btn_clear_photo_file:

                String cameraFileDir = FilePathUtils.getSdcardPath() + File.separator + "DCIM/Camera";
                boolean isDeletePhotoSuccess = FileUtils.deleteFile(cameraFileDir);
                shortToast("清理文件相册照片" + (isDeletePhotoSuccess ? "成功" : "失败"));

                tv_demo.setTextIsSelectable(false);
                tv_demo.setSelectAllOnFocus(false);

                break;
            default:
                break;
        }

    }
}
