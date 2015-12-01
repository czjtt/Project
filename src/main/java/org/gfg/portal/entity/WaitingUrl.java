package org.gfg.portal.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by NS on 2015/10/8.
 */
@Entity
@Table(name = "url_waiting")
public class WaitingUrl implements Serializable{

    private static final long serialVersionUID = 6444332835662547840L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "url",nullable = false)
    private String url;

    public WaitingUrl(String url) {
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
