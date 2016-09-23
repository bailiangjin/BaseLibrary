package com.kevin.baselibrary.utils.device;

import android.content.Context;
import android.nfc.NfcManager;
import android.provider.Settings;

import com.kevin.baselibrary.app.AppUtils;

/**
 * Created by bailiangjin on 16/9/23.
 */

public class NFCUtils {




    public static boolean isNFCpen() {
        NfcManager nfcManager = (NfcManager) AppUtils.getContext()
                .getSystemService(Context.NFC_SERVICE);
        return nfcManager.getDefaultAdapter().isEnabled();
    }


    public static void toSetNFC() {
        String action= Settings.ACTION_NFC_SETTINGS;
        DeviceSetUtils.toSetByAction(action);
    }



}
