package com.example.springpebble.control;

import com.example.springpebble.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

/**
 * Created by yookeun on 2018. 3. 9..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardControllerTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void board_list_count() {
        assertEquals(3, boardService.selectBoardCount());
    }
}