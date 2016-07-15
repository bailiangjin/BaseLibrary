package com.kevin.baselibrary.widget.listener;

import android.content.DialogInterface;

/**
 * @author bailiangjin
 */
public interface PNDialogListener {

    public void onPositive(DialogInterface dialog, int which);


    public void onNegative(DialogInterface dialog, int which);

}
