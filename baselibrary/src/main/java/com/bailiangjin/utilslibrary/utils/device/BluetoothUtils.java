package com.bailiangjin.utilslibrary.utils.device;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;

import com.bailiangjin.utilslibrary.utils.app.AppUtils;

/**
 * Created by bailiangjin on 16/9/23.
 */

public class BluetoothUtils {

    public static boolean isBluetoothEnabled() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            BluetoothManager bluetoothManager = (BluetoothManager) AppUtils.getContext()
                    .getSystemService(Context.BLUETOOTH_SERVICE);
            return bluetoothManager.getAdapter().isEnabled();
        } else {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            return bluetoothAdapter.isEnabled();

        }
    }

    public static boolean toggleBluetooth(boolean isOn) {
        if (isOn) {
            return enableBluetooth();
        } else {
            return disableBluetooth();
        }

    }

    public static boolean enableBluetooth() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            BluetoothManager bluetoothManager = (BluetoothManager) AppUtils.getContext()
                    .getSystemService(Context.BLUETOOTH_SERVICE);
            return bluetoothManager.getAdapter().enable();
        } else {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            return bluetoothAdapter.enable();
        }
    }

    public static boolean disableBluetooth() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            BluetoothManager bluetoothManager = (BluetoothManager) AppUtils.getContext()
                    .getSystemService(Context.BLUETOOTH_SERVICE);
            return bluetoothManager.getAdapter().disable();
        } else {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            return bluetoothAdapter.disable();
        }
    }


}
