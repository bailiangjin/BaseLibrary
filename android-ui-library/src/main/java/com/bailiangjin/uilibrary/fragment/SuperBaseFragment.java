package com.bailiangjin.uilibrary.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bailiangjin.uilibrary.R;
import com.bailiangjin.uilibrary.titlebar.TitleBarBuilder;

/**
 * Created by bailiangjin on 2016/10/24.
 */

public abstract class SuperBaseFragment extends Fragment {


    protected View rootView;

    private LinearLayout ll_root;

    private FrameLayout baseContainer;

    private Toolbar toolbar;

    protected TitleBarBuilder titleBarBuilder;

    public SuperBaseFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //LogUtils.d("Fragment:::-->>onCreateView");
        if (null == rootView) {
            rootView = initRootView(inflater, container);
        }
        beforeViewBind();
        bindView(rootView);
        initView();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("TAG" + getClass().getSimpleName(), "Fragment:::-->>onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        initListener();
        initData(savedInstanceState);
    }


    /**
     * 初始化父类UI
     */
    private View initRootView(LayoutInflater layoutInflater, ViewGroup container) {
        rootView = layoutInflater.inflate(R.layout.fragment_base_xml, container, false);
        ll_root = (LinearLayout) rootView.findViewById(R.id.ll_root);
        baseContainer = (FrameLayout) rootView.findViewById(R.id.baseContainer);
        toolbar = (Toolbar) rootView.findViewById(R.id.common_toolbar);
        View ChildView = layoutInflater.inflate(getLayoutResId(), null);
        baseContainer.addView(ChildView);
        titleBarBuilder = new TitleBarBuilder(getActivity(), toolbar);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            mToolbar.setPadding(0, CommonUtils.getStatusBarHeight(getActivity()), 0, 0);
//        }
        return rootView;
    }

    /**
     * 隐藏公共title
     */
    public void hideCommonBaseTitle() {
        if (toolbar != null) {
            toolbar.setVisibility(View.GONE);
        }
    }


    /**
     * 显示公共的title
     */
    public void showCommonBaseTitle() {

        if (toolbar != null) {
            toolbar.setVisibility(View.VISIBLE);
        }

    }


    /**
     * 设置隐藏状态栏高度
     */
    public void hideStatusBarHight() {
        ll_root.setFitsSystemWindows(false);
    }

    /**
     * 设置添加状态栏高度
     */
    public void showStatusBarHight() {
        ll_root.setFitsSystemWindows(true);
    }


    @Override
    public void onAttach(Activity activity) {
        //LogUtils.d("Fragment:::-->>onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //LogUtils.d("Fragment:::-->>onCreate");
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onStart() {
        //LogUtils.d("Fragment:::-->>onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        //LogUtils.d("Fragment:::-->>onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        //LogUtils.d("Fragment:::-->>onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        //LogUtils.d("Fragment:::-->>onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        //LogUtils.d("Fragment:::-->>onDestroyView");
        super.onDestroyView();
        unBindView();
    }

    @Override
    public void onDestroy() {
        //LogUtils.d("Fragment:::-->>onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        //LogUtils.d("Fragment:::-->>onDetach");
        super.onDetach();
    }


    /**
     * shortToast toast by string
     *
     * @param string
     */
    protected void shortToast(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }

    /**
     * shortToast toast by res id
     *
     * @param resId
     */
    protected void shortToast(int resId) {
        Toast.makeText(getActivity(), getActivity().getResources().getString(resId), Toast.LENGTH_SHORT).show();
    }

    /**
     * long toast
     *
     * @param string
     */
    protected void longToast(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }

    /**
     * long toast
     *
     * @param resId
     */
    protected void longToast(int resId) {
        Toast.makeText(getActivity(), getActivity().getResources().getString(resId), Toast.LENGTH_LONG).show();
    }


    /**
     * 设置layout ResId
     *
     * @return ResId
     */
    protected abstract int getLayoutResId();


    protected abstract void beforeViewBind();

    /**
     * BaseFragment 添加view绑定使用 具体Fragment不需要Override该方法
     *
     * @param view
     */
    protected abstract void bindView(View view);

    protected abstract void initView();

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void unBindView();

    protected abstract void initListener();

}
