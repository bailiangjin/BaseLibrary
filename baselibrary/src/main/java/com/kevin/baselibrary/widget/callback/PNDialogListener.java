package com.kevin.baselibrary.widget.callback;

import android.content.DialogInterface;

public interface PNDialogListener {

    public void onPositive(DialogInterface dialog, int which);


    public void onNegative(DialogInterface dialog, int which);

}
