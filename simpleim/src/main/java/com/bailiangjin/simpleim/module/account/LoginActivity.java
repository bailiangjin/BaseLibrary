package com.bailiangjin.simpleim.module.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.appcommon.base.BaseActivity;
import com.bailiangjin.simpleim.constants.IntentKey;
import com.bailiangjin.simpleim.engine.logicutils.AccountUtils;
import com.bailiangjin.simpleim.engine.logicutils.LoginResult;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 登录
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_username)
    protected EditText et_username;// 用户名
    @BindView(R.id.et_password)
    protected EditText et_password;// 密码
    @BindView(R.id.btn_login)
    protected Button btn_login;// 登录按钮
    @BindView(R.id.cb_save_password)
    protected CheckBox cb_save_password;
    @BindView(R.id.tv_register)
    protected TextView tv_register;

    private String userName = null;
    private String passWord = null;
    private boolean isSavePassword;

    public static void start(Activity activity){
        Intent intent = new Intent(activity,LoginActivity.class);
        activity.startActivity(intent);
    }

    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initIntentData() {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initMyData();
    }



    @Override
    protected void initView() {
        hideCommonBaseTitle();
        if (AccountUtils.isLoginStatus()){
            com.bailiangjin.simpleim.MainActivity.start(this);
            finish();
        }
        titleBarBuilder.setTitleText("登录简信");
    }

    @Override
    protected void initData() {
        initMyData();
    }


    /**
     * 初始化数据
     */
    private void initMyData() {
        String isNewUser;
        String userName;
        String passWord;
        boolean isChecked;

        isNewUser = getIntent().getStringExtra(IntentKey.IS_NEW_USER);

        //是否为新注册页面跳转过来
        if ("true".equals(isNewUser)) {
            userName = getIntent().getStringExtra(IntentKey.USER_NAME);
            passWord = getIntent().getStringExtra(IntentKey.PASSWORD);
            isChecked = false;
        } else {
            userName = AccountUtils.getUserName();
            passWord = AccountUtils.getPassword();
            isChecked = AccountUtils.isSavePassword();
        }

        et_username.setText(TextUtils.isEmpty(userName) ? "" : userName);
        et_password.setText(TextUtils.isEmpty(passWord) ? "" : passWord);
        cb_save_password.setChecked(isChecked);
    }

    private void login(String userName, String passWord) {
        shortToast("点击了登录按钮");
        // TODO:执行登录逻辑
        //暂时模拟 每次都成功
        handler.sendEmptyMessage(LoginResult.SUCCESS);

    }


    @OnClick({R.id.btn_login, R.id.tv_register})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login://登录成功
                //获取用户名
                userName = et_username.getText().toString().trim();
                //获取密码
                passWord = et_password.getText().toString().trim();
                //获取记住密码框勾选状态
                isSavePassword = cb_save_password.isChecked();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
                    shortToast(R.string.username_pwd_cannot_be_null);
                    return;
                }
                //调用登录
                login(userName, passWord);
                break;
            case R.id.tv_register://点击注册
                //跳转到注册页
                RegisterActivity.start(LoginActivity.this);
                this.finish();
            default:
                break;

        }
    }



    @Override
    protected void handleMsg(Message msg) {
        switch (msg.what) {
            case LoginResult.SUCCESS:
                shortToast("登录成功");
                // TODO:密码加密后存放
                //保存登录信息到SP
                AccountUtils.saveLoginInfo(userName, passWord, isSavePassword);
                //进入下一个界面
                com.bailiangjin.simpleim.MainActivity.start(this);
                //结束当前界面
                this.finish();
                break;
            case LoginResult.FAILED:
                shortToast("登录失败");
                // TODO:登录失败 给出原因
                break;
            case LoginResult.ERRROR:
                shortToast("登录异常");
                // TODO:登录异常 给出提示
                break;
            default:
                break;
        }

    }

}
