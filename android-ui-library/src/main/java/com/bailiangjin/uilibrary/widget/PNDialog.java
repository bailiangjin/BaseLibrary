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
public class PNDialog {

    AlertDialog alertDialog;
    Context mContext;
    String title;
    String content;
    String positiveStr;
    String negativeStr;
    boolean cancelable;
    boolean noTitle;

    protected PNDialog(final Builder builder) {
        this.mContext = builder.mContext;
        this.title = builder.title;
        this.content = builder.content;
        this.positiveStr = builder.positiveStr;
        this.negativeStr = builder.negativeStr;
        this.cancelable = builder.cancelable;
        this.noTitle = builder.noTitle;

        alertDialog = new android.support.v7.app.AlertDialog.Builder(mContext)
                .setCancelable(cancelable).create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        window.setContentView(R.layout.dialog_common);
        TextView tv_title = (TextView) window.findViewById(R.id.tv_title);
        TextView tv_content = (TextView) window.findViewById(R.id.tv_content);
        TextView tv_cancel = (TextView) window.findViewById(R.id.tv_cancel);
        TextView tv_confirm = (TextView) window.findViewById(R.id.tv_confirm);

        tv_title.setVisibility(noTitle ? View.GONE : View.VISIBLE);

        tv_title.setText(title);
        tv_content.setText(content);
        tv_cancel.setText(negativeStr);
        tv_confirm.setText(positiveStr);

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                builder.PNDialogListener.onNegative();
            }
        });

        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                builder.PNDialogListener.onPositive();
            }
        });
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPositiveStr() {
        return positiveStr;
    }

    public String getNegativeStr() {
        return negativeStr;
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
        String positiveStr;
        String negativeStr;
        boolean cancelable;
        boolean noTitle;

        PNDialogListener PNDialogListener;

        public Builder() {
            this.title = "提示";
            this.content = "";
            this.positiveStr = "确定";
            this.negativeStr = "取消";
            this.cancelable = true;
            this.noTitle = false;
        }

        public PNDialog create(Context context, PNDialogListener PNDialogListener) {
            this.mContext = context;
            this.PNDialogListener = PNDialogListener;
            return new PNDialog(this);
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setPositiveStr(String positiveStr) {
            this.positiveStr = positiveStr;
            return this;
        }

        public Builder setNegativeStr(String negativeStr) {
            this.negativeStr = negativeStr;
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
