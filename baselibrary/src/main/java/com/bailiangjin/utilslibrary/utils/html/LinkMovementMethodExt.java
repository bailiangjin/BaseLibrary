package com.bailiangjin.utilslibrary.utils.html;


import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

import com.bailiangjin.utilslibrary.utils.LogUtils;


public class LinkMovementMethodExt extends LinkMovementMethod {
    private static LinkMovementMethod sInstance;
    private Handler handler = null;
    private Class spanClass = null;

    public static MovementMethod getInstance(Handler _handler, Class _spanClass) {
        if (sInstance == null) {
            sInstance = new LinkMovementMethodExt();
            ((LinkMovementMethodExt) sInstance).handler = _handler;
            ((LinkMovementMethodExt) sInstance).spanClass = _spanClass;
        }

        return sInstance;
    }

    int x1;
    int x2;
    int y1;
    int y2;

    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer,
                                MotionEvent event) {
        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN) {
            x1 = (int) event.getX();
            y1 = (int) event.getY();
        }

        if (action == MotionEvent.ACTION_UP) {
            x2 = (int) event.getX();
            y2 = (int) event.getY();

            int touchSlop= ViewConfiguration.get(widget.getContext()).getScaledTouchSlop();
            LogUtils.d("touchSlop:"+touchSlop);
            if (Math.abs(x1 - x2) <  touchSlop&& Math.abs(y1 - y2) < touchSlop) {

                x2 -= widget.getTotalPaddingLeft();
                y2 -= widget.getTotalPaddingTop();

                x2 += widget.getScrollX();
                y2 += widget.getScrollY();

                /**
                 * get you interest span
                 */
                Object[] spans = buffer.getSpans(0, widget.getText().length() - 1, spanClass);
                if (spans.length != 0) {
                    //显示选中区域阴影
                    //Selection.setSelection(buffer,
                    //		buffer.getSpanStart(spans[0]),
                    //		buffer.getSpanEnd(spans[spans.length-1]));
                    MessageSpan obj = new MessageSpan();
                    obj.setObj(spans);
                    obj.setView(widget);
                    Message message = handler.obtainMessage();
                    message.obj = obj;
                    message.what = 200;
                    message.sendToTarget();
                }
            }
        }

        return super.onTouchEvent(widget, buffer, event);


    }


    public boolean canSelectArbitrarily() {
        return true;
    }

    public boolean onKeyUp(TextView widget, Spannable buffer, int keyCode,
                           KeyEvent event) {
        return false;

    }
}
