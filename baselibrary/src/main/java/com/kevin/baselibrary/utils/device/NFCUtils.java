package com.kevin.baselibrary.utils.device;

import android.content.Context;
import android.nfc.NfcManager;
import android.provider.Settings;

import com.kevin.baselibrary.app.AppUtils;
import com.kevin.baselibrary.utils.LogUtils;

/**
 * Created by bailiangjin on 16/9/23.
 */

public class NFCUtils {

    public static boolean isNFCOpen() {
        NfcManager nfcManager = (NfcManager) AppUtils.getContext()
                .getSystemService(Context.NFC_SERVICE);

        return null != nfcManager && nfcManager.getDefaultAdapter().isEnabled();
    }


    public static void toSetNFC() {

        NfcManager nfcManager = (NfcManager) AppUtils.getContext()
                .getSystemService(Context.NFC_SERVICE);
        if (null != nfcManager) {
            String action = Settings.ACTION_NFC_SETTINGS;
            DeviceSetUtils.toSetByAction(action);
        } else {
            LogUtils.e("当前设备不支持NFC");
        }

    }

}
