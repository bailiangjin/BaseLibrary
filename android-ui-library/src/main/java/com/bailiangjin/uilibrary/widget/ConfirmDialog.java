package com.bailiangjin.uilibrary.widget;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.bailiangjin.uilibrary.R;


/**
 * 清理 APP配置类 建造者模式范例
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/11/12 17:32
 */
public class ConfirmDialog {

    AlertDialog alertDialog;
    Context mContext;
    String title;
    String content;
    String confirmStr;
    boolean cancelable;
    boolean noTitle;

    protected ConfirmDialog(final Builder builder) {
        this.mContext = builder.mContext;
        this.title = builder.title;
        this.content = builder.content;
        this.confirmStr = builder.confirmStr;
        this.cancelable = builder.cancelable;
        this.noTitle = builder.noTitle;

        alertDialog = new AlertDialog.Builder(mContext)
                .setCancelable(cancelable).create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        window.setContentView(R.layout.dialog_confirm);
        TextView tv_title = (TextView) window.findViewById(R.id.tv_title);
        TextView tv_content = (TextView) window.findViewById(R.id.tv_content);
        TextView tv_confirm = (TextView) window.findViewById(R.id.tv_confirm);

        tv_title.setVisibility(noTitle ? View.GONE : View.VISIBLE);

        tv_title.setText(title);
        tv_content.setText(content);
        tv_confirm.setText(confirmStr);


        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                builder.confirmDialogListener.onConfirm();
            }
        });
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getConfirmStr() {
        return confirmStr;
    }


    public boolean isCancelable() {
        return cancelable;
    }


    public void show() {
        alertDialog.show();
    }

    public static class Builder {
        Context mContext;
        String title;
        String content;
        String confirmStr;
        boolean cancelable;
        boolean noTitle;

        ConfirmDialogListener confirmDialogListener;

        public Builder() {
            this.title = "提示";
            this.content = "";
            this.confirmStr = "确定";
            this.cancelable = true;
            this.noTitle = false;
        }

        public ConfirmDialog create(Context context, ConfirmDialogListener confirmDialogListener) {
            this.mContext = context;
            this.confirmDialogListener = confirmDialogListener;
            return new ConfirmDialog(this);
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setConfirmStr(String confirmStr) {
            this.confirmStr = confirmStr;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setNoTitle(boolean noTitle) {
            this.noTitle = noTitle;
            return this;
        }
    }

}
