package org.gfg.portal.entity;

import java.io.Serializable;

/**
 * Created by NS on 2015/10/8.
 */
public class BaseUrl implements Serializable{

    private Integer id;
    private String url;

    public BaseUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
