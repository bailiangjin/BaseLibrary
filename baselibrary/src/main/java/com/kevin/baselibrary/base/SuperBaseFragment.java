package com.kevin.baselibrary.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;

public abstract class SuperBaseFragment extends Fragment  {

    protected View rootView;

    @Override
    public void onAttach(Activity activity) {
        LogUtils.d("Fragment:::-->>onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        LogUtils.d("Fragment:::-->>onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtils.d("Fragment:::-->>onCreateView");
        rootView = inflater.inflate(getLayoutResId(), container, false);
        initView();
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        LogUtils.d("Fragment:::-->>onActivityCreated");
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    @Override
    public void onStart() {
        LogUtils.d("Fragment:::-->>onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        LogUtils.d("Fragment:::-->>onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        LogUtils.d("Fragment:::-->>onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        LogUtils.d("Fragment:::-->>onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        LogUtils.d("Fragment:::-->>onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        LogUtils.d("Fragment:::-->>onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        LogUtils.d("Fragment:::-->>onDetach");
        super.onDetach();
    }


    /**
     * 设置layout ResId
     *
     * @return ResId
     */
    protected abstract int getLayoutResId();



    /**
     * shortToast toast by string
     *
     * @param string
     */
    protected void shortToast(String string) {
        ToastUtils.shortToast(string);
    }

    /**
     * shortToast toast by res id
     *
     * @param resId
     */
    protected void shortToast(int resId) {
        ToastUtils.shortToast(resId);
    }

    /**
     * long toast
     *
     * @param string
     */
    protected void longToast(String string) {
        ToastUtils.longToast(string);
    }

    /**
     * long toast
     *
     * @param resId
     */
    protected void longToast(int resId) {
        ToastUtils.longToast( resId);
    }


    protected abstract void initView();

    protected abstract void initData();

}
