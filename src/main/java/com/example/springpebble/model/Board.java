package com.example.springpebble.model;

import com.example.springpebble.util.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * Created by yookeun on 2018. 1. 16..
 */
@Data
public class Board {
    private int id;
    private String title;
    private String content;
    private String score;
    private Date regDate;
}
