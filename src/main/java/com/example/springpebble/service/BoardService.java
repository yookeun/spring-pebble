package com.example.springpebble.service;

import com.example.springpebble.mapper.BoardMapper;
import com.example.springpebble.model.Board;
import com.example.springpebble.model.BoardSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yookeun on 2018. 3. 9..
 */
@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public List<Board> selectBoard(BoardSearch boardSearch) {
        return boardMapper.selectBoard(boardSearch);
    }

    public int selectBoardCount(){
        return boardMapper.selectBoardCount();
    }

    public int insertBoard(Board board) {
        return boardMapper.insertBoard(board);
    }
}
