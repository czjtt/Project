package org.gfg.portal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by NS on 2015/10/8.
 */
@Entity
@Table(name = "url_analysed")
public class AnalysedUrl implements Serializable{

    private static final long serialVersionUID = -8204878755083794503L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "url",nullable = false)
    private String url;
    @Column(name = "createDate")
    private Date createDate;

    public AnalysedUrl() {
    }

    public AnalysedUrl(String url) {
        this.url = url;
    }

    public AnalysedUrl(String url, Date createDate) {
        this.url = url;
        this.createDate = createDate;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
