package com.kevin.building.demo.widget.draggridview;

import android.app.Activity;
import android.os.Bundle;

import com.kevin.baselibrary.view.draggridview.DragGridView;
import com.kevin.building.R;
import com.kevin.building.model.TaskItemBean;

import java.util.ArrayList;
import java.util.List;


public class DragGridViewActivity extends Activity {
    private List<TaskItemBean> dataSourceList = new ArrayList<TaskItemBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_draggridview);

        DragGridView mDragGridView = (DragGridView) findViewById(R.id.dragGridView);
        for (int i = 0; i < 15; i++) {
            TaskItemBean taskItemBean = new TaskItemBean();
            taskItemBean.setName("拖拽 " + Integer.toString(i));
            dataSourceList.add(taskItemBean);
        }

        final DragAdapter mDragAdapter = new DragAdapter(this, dataSourceList);

        mDragGridView.setAdapter(mDragAdapter);
    }


}
