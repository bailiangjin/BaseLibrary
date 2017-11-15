package com.bailiangjin.demo.demo.file;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bailiangjin.demo.R;
import com.bailiangjin.demo.base.BaseActivity;
import com.bailiangjin.javabaselib.utils.FileUtils;
import com.bailiangjin.utilslibrary.utils.file.FilePathUtil;

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

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_file_operation;
    }

    @Override
    protected void beforeViewBind(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {


    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


    @OnClick({R.id.btn_clear_im_download_file, R.id.btn_clear_photo_file})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_clear_im_download_file:

                String gomeDownloadFileDir = FilePathUtil.getSdcardPath() + File.separator + "GoMeConnect/GoMeDownLoad";
                boolean isSuccess = FileUtils.deleteFile(gomeDownloadFileDir);
                shortToast("清理文件GoMe下载文件" + (isSuccess ? "成功" : "失败"));

                break;

            case R.id.btn_clear_photo_file:

                String cameraFileDir = FilePathUtil.getSdcardPath() + File.separator + "DCIM/Camera";
                boolean isDeletePhotoSuccess = FileUtils.deleteFile(cameraFileDir);
                shortToast("清理文件相册照片" + (isDeletePhotoSuccess ? "成功" : "失败"));

                break;
            default:
                break;
        }

    }
}
