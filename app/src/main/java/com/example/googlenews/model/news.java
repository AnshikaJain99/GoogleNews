package com.example.googlenews.model;

public class news {

    private String title;
    private String desc;
    private String imgurl;
    private String content;
    private String descurl;

    public news() {
    }

    public news(String title, String desc, String imgurl, String content, String descurl) {
        this.title = title;
        this.desc = desc;
        this.imgurl = imgurl;
        this.content = content;
        this.descurl = descurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescurl() {
        return descurl;
    }

    public void setDescurl(String descurl) {
        this.descurl = descurl;
    }
    @Override
    public String toString()
    {
        return "news{"+"title="+title+"content="+content+"}\n\n";
    }
}
