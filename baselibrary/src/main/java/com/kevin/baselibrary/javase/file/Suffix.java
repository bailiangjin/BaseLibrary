package com.kevin.baselibrary.javase.file;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：16/2/26 23:02
 */

import java.io.File;
import java.io.FilenameFilter;

public class Suffix implements FilenameFilter {
    private String suffix;
    public Suffix(String suffix) {
        super();
        this.suffix = suffix;
    }
    public boolean accept(File dir, String name) {

        return name.endsWith(suffix);
    }

}

