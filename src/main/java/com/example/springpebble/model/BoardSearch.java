package com.example.springpebble.model;

import com.example.springpebble.util.Pagination;
import lombok.Data;

/**
 * Created by yookeun on 2018. 3. 9..
 */
@Data
public class BoardSearch extends Pagination {
    private String title;
}
