package com.kevin.baselibrary.config;

/**
 * 清理 APP配置类 建造者模式范例
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/11/12 17:32
 */
public class CleanOptions {
    /**
     * 是否清空应用根目录
     */
    private boolean cleanRootDir;
    /**
     * 是否清空数据库目录
     */
    private boolean cleanDBDir;
    /**
     * 是否清空媒体文件目录
     */
    private boolean cleanMediaDir;
    /**
     * 是否清空其他文件目录
     */
    private boolean cleanOtherDir;

    public CleanOptions(Builder builder) {
        this.cleanRootDir = builder.cleanRootDir;
        this.cleanDBDir = builder.cleanDBDir;
        this.cleanMediaDir = builder.cleanMediaDir;
        this.cleanOtherDir = builder.cleanOtherDir;
    }

    public boolean isCleanRootDir() {
        return cleanRootDir;
    }

    public boolean isCleanDBDir() {
        return cleanDBDir;
    }

    public boolean isCleanMediaDir() {
        return cleanMediaDir;
    }

    public boolean isCleanOtherDir() {
        return cleanOtherDir;
    }

    public static class Builder {
        private boolean cleanRootDir;
        private boolean cleanDBDir;
        private boolean cleanMediaDir;
        private boolean cleanOtherDir;

        public Builder() {
            this.cleanRootDir = false;
            this.cleanDBDir = false;
            this.cleanMediaDir = false;
            this.cleanOtherDir = false;
        }

        public CleanOptions build() {
            return new CleanOptions(this);
        }

        public Builder cleanRootDir(boolean cleanRootDir) {
            this.cleanRootDir = cleanRootDir;
            return this;
        }

        public Builder cleanDBDir(boolean cleanDBDir) {
            this.cleanDBDir = cleanDBDir;
            return this;
        }

        public Builder cleanMediaDir(boolean cleanMediaDir) {
            this.cleanMediaDir = cleanMediaDir;
            return this;
        }

        public Builder cleanOtherDir(boolean cleanOtherDir) {
            this.cleanOtherDir = cleanOtherDir;
            return this;
        }
    }

}
