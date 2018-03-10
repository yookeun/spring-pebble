package com.example.springpebble.mapper;

import com.example.springpebble.model.Board;
import com.example.springpebble.model.BoardSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by yookeun on 2018. 1. 16..
 */
@Mapper
public interface BoardMapper {
    public List<Board> selectBoard(BoardSearch boardSearch);
    public int selectBoardCount();
    public int insertBoard(Board board);
}
