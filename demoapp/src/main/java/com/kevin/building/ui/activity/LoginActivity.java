package com.kevin.building.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.kevin.baselibrary.constant.SuperSPKey;
import com.kevin.baselibrary.utils.SPUtils;
import com.kevin.building.R;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.constants.LoginResult;
import com.kevin.building.ui.activity.logicutils.AccountUtils;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity {

    private EditText et_username;// 用户名
    private EditText et_password;// 密码
    private Button btn_login;// 登录按钮
    private CheckBox cb_save_password;
    private String userName = null;
    private String passWord = null;
    private boolean isSavePassword;

    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        // LogUtils.d("手机型号：" + android.os.Build.MODEL);
        // longToastString("手机型号：" + android.os.Build.MODEL);
    }

    @Override
    protected void initView() {


        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        cb_save_password = (CheckBox) findViewById(R.id.cb_save_password);

    }

    @Override
    protected void initLogic() {

    }


    /**
     * 初始化数据
     */
    private void initData() {
        String userName = SPUtils.getString(SuperSPKey.USER_NAME);
        et_username.setText(TextUtils.isEmpty(userName) ? "" : userName);

        String passWord = SPUtils.getString(SuperSPKey.PASSWORD);
        et_password.setText(!TextUtils.isEmpty(passWord) ? "" : passWord);

        boolean isChecked = SPUtils.getBoolean(SuperSPKey.SAVEPWD);
        cb_save_password.setChecked(isChecked);
    }

    private void login(String userName, String passWord) {
        show("点击了登录按钮");
        // TODO:执行登录逻辑
        //暂时模拟 每次都成功
        handler.sendEmptyMessage(LoginResult.SUCCESS);

    }

    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login://登录成功
                //获取用户名
                userName = et_username.getText().toString().trim();
                //获取密码
                passWord = et_password.getText().toString().trim();
                //获取记住密码框勾选状态
                isSavePassword = cb_save_password.isChecked();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
                    show(R.string.username_pwd_cannot_be_null);
                    return;
                }
                //调用登录
                login(userName, passWord);
                break;

            default:
                break;

        }
    }

    @Override
    protected void handleMsg(Message msg) {
        switch (msg.what) {
            case LoginResult.SUCCESS:
                show("登录成功");
                // TODO:密码加密后存放
                //保存登录信息到SP
                AccountUtils.saveLoginInfo(userName, passWord, isSavePassword);
                //进入下一个界面
                Intent intent = new Intent(this, UserListActivity.class);
                AppManager.getInstance().startActivity(LoginActivity.this, intent);
                //结束当前界面
                this.finish();
                break;
            case LoginResult.FAILED:
                show("登录失败");
                // TODO:登录失败 给出原因
                break;
            case LoginResult.ERRROR:
                show("登录异常");
                // TODO:登录异常 给出提示
                break;
            default:
                break;
        }

    }

}
