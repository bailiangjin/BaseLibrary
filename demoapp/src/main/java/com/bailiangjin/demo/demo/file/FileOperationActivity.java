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
//        btn_clear_im_download_file= (Button) findViewById(R.id.btn_clear_im_download_file);
//        btn_clear_im_download_file.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String gomeDownloadFileDir = FilePathUtil.getSdcardPath() + File.separator + "GoMeConnect/GoMeDownLoad";
//
//              boolean isSuccess=  FileUtils.deleteFile(gomeDownloadFileDir);
//
//                shortToast("清理文件GoMe下载文件"+(isSuccess ?"成功":"失败"));
//            }
//        });
//
//        btn_clear_photo_file= (Button) findViewById(R.id.btn_clear_photo_file);
//        btn_clear_photo_file.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String gomeDownloadFileDir = FilePathUtil.getSdcardPath() + File.separator + "DCIM/Camera";
//                boolean isSuccess=  FileUtils.deleteFile(gomeDownloadFileDir);
//
//                shortToast("清理文件相册照片"+(isSuccess ?"成功":"失败"));
//            }
//        });

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }



    @OnClick({R.id.btn_clear_im_download_file})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_clear_im_download_file:
                shortToast("点击了清理文件");
                String gomeDownloadFileDir = FilePathUtil.getSdcardPath() + File.separator + "GoMeConnect/GoMeDownLoad";
                FileUtils.deleteFile(gomeDownloadFileDir);
                break;
            default:
                break;
        }

    }
}
