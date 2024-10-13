package com.yf.bet.model;

/**
 * <pre>
 *     author: 杨帆
 *     email: yangfan@haibingtech.com
 *     date: 2024/10/7 17:57
 *     desc  :
 *     history:
 * </pre>
 */
public class NormalItem {

    public NormalItem(String title, int resourceId) {
        this.title = title;
        this.resourceId = resourceId;
    }

    private String title;
    private int resourceId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
