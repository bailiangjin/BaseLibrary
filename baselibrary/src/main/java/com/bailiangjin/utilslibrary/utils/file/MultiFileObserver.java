package com.bailiangjin.utilslibrary.utils.file;

/**
 * Created by bailiangjin on 16/4/5.
 */

import android.os.FileObserver;
import android.util.Log;

import com.bailiangjin.utilslibrary.interfaze.listener.IFileListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MultiFileObserver extends FileObserver {

    /**
     * Only modification events
     */
    public static int CHANGES_ONLY = CREATE | MODIFY | DELETE | CLOSE_WRITE | DELETE_SELF | MOVE_SELF | MOVED_FROM | MOVED_TO;

    private List<SingleFileObserver> mObservers;
    private String mPath;
    private int mMask;
    /**
     * 文件状态监听回调
     */
    private IFileListener fileListener;

//    public MultiFileObserver(String path) {
//        this(path, ALL_EVENTS);
//    }

    public MultiFileObserver(String path,IFileListener fileListener) {
        this(path, ALL_EVENTS);
        this.fileListener=fileListener;
    }

    protected MultiFileObserver(String path, int mask) {
        super(path, mask);
        mPath = path;
        mMask = mask;
    }

    @Override
    public void startWatching() {
        if (mObservers != null)
            return;

        mObservers = new ArrayList<SingleFileObserver>();
        Stack<String> stack = new Stack<String>();
        stack.push(mPath);

        while (!stack.isEmpty()) {
            String parent = stack.pop();
            mObservers.add(new SingleFileObserver(parent, mMask));
            File path = new File(parent);
            File[] files = path.listFiles();
            if (null == files)
                continue;
            for (File f : files) {
                if (f.isDirectory() && !f.getName().equals(".")
                        && !f.getName().equals("..")) {
                    stack.push(f.getPath());
                }
            }
        }

        for (int i = 0; i < mObservers.size(); i++) {
            SingleFileObserver sfo = mObservers.get(i);
            sfo.startWatching();
        }
    }

    ;

    @Override
    public void stopWatching() {
        if (mObservers == null)
            return;

        for (int i = 0; i < mObservers.size(); i++) {
            SingleFileObserver sfo = mObservers.get(i);
            sfo.stopWatching();
        }

        mObservers.clear();
        mObservers = null;
    }



    @Override
    public void onEvent(int event, String path) {
        Log.i("RecursiveFileObserver", "ACCESS: " + path);

        switchEvent(event, path);
    }



    /**
     * Monitor single directory and dispatch all events to its parent, with full
     * path.
     */
    class SingleFileObserver extends FileObserver {
        String mPath;

        public SingleFileObserver(String path) {
            this(path, ALL_EVENTS);
            mPath = path;
        }

        public SingleFileObserver(String path, int mask) {
            super(path, mask);
            mPath = path;
        }

        @Override
        public void onEvent(int event, String path) {
            String newPath = mPath + "/" + path;
            switchEvent(event, newPath);
        }
    }


    /**
     * 事件分发
     * @param event
     * @param path
     */
    private void switchEvent(int event, String path) {
        switch (event) {
            case FileObserver.ACCESS:
                Log.i("RecursiveFileObserver", "ACCESS: " + path);
                break;
            case FileObserver.ATTRIB:
                Log.i("RecursiveFileObserver", "ATTRIB: " + path);
                break;
            case FileObserver.CLOSE_NOWRITE:
                Log.i("RecursiveFileObserver", "CLOSE_NOWRITE: " + path);
                fileListener.onCloseNoWrite(path);
                break;
            case FileObserver.CLOSE_WRITE:
                Log.i("RecursiveFileObserver", "CLOSE_WRITE: " + path);
                fileListener.onCloseWrite(path);
                break;
            case FileObserver.CREATE:
                fileListener.onCreate(path);
                Log.i("RecursiveFileObserver", "CREATE: " + path);
                break;
            case FileObserver.DELETE:
                Log.i("RecursiveFileObserver", "DELETE: " + path);
                fileListener.onDelete(path);
                break;
            case FileObserver.DELETE_SELF:
                Log.i("RecursiveFileObserver", "DELETE_SELF: " + path);
                break;
            case FileObserver.MODIFY:
                Log.i("RecursiveFileObserver", "MODIFY: " + path);
                fileListener.onModify(path);
                break;
            case FileObserver.MOVE_SELF:
                Log.i("RecursiveFileObserver", "MOVE_SELF: " + path);
                break;
            case FileObserver.MOVED_FROM:
                Log.i("RecursiveFileObserver", "MOVED_FROM: " + path);
                break;
            case FileObserver.MOVED_TO:
                Log.i("RecursiveFileObserver", "MOVED_TO: " + path);
                break;
            case FileObserver.OPEN:
                fileListener.onOpen(path);
                Log.i("RecursiveFileObserver", "OPEN: " + path);
                break;
            default:
                Log.i("RecursiveFileObserver", "DEFAULT(" + event + " : " + path);
                break;
        }
    }
} 
