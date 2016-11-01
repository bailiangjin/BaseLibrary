package com.kevin.baselibrary.utils.device;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.os.Build;

import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;

/**
 * Created by bailiangjin on 2016/10/18.
 */

public class CheckCameraUtils {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static boolean isCameraInUse(Context context) {
        CameraManager manager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                String[] cIds = manager.getCameraIdList();
                if (null != cIds && cIds.length > 0) {
                    manager.openCamera(cIds[0], new CameraDevice.StateCallback() {
                        @Override
                        public void onOpened(CameraDevice camera) {

                        }

                        @Override
                        public void onDisconnected(CameraDevice camera) {

                        }

                        @Override
                        public void onError(CameraDevice camera, int error) {

                        }
                    }, null);
                }

                return false;
            } catch (CameraAccessException e) {
                e.printStackTrace();
                int reason = e.getReason();

                switch (reason) {
                    case CameraAccessException.CAMERA_DISABLED:
                        return true;
                    default:
                        return false;
                }
            }
        } else {
            return false;
        }

    }


    /**
     * 检测 麦克风是否被占用
     *
     * @param context
     * @return
     */
    public static boolean isMcInUse(Context context) {

        AudioManager manager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        int mcMode = manager.getMode();
        ToastUtils.shortToast("mode:"+mcMode);
        LogUtils.e("mcMode:"+mcMode);

        switch (mcMode) {
            case AudioManager.MODE_IN_COMMUNICATION:
            case AudioManager.MODE_IN_CALL:
                return true;
            default:
                return false;
        }
    }


    /**
     * Check if this device has a camera
     */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }
}
