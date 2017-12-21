package com.yuin.smalltools.entity.trans;


import java.util.ArrayList;
import java.util.List;

public class TransInfoVo {
    private String site;
    private String title;
    private List<String> urls = new ArrayList<>();

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
