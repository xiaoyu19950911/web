package com.xiaoyu.web.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by tengj on 2017/3/7.
 */
@Data
@Entity
@NoArgsConstructor
public class LearnResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String author;

    private String title;

    private String url;

    public LearnResource(String author, String title, String url) {
        this.author = author;
        this.title = title;
        this.url = url;
    }
}
