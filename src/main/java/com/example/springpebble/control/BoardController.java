package com.example.springpebble.control;

import com.example.springpebble.model.Board;
import com.example.springpebble.model.BoardSearch;
import com.example.springpebble.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by yookeun on 2018. 3. 9..
 */
@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping({"/", "/board/list"})
    public ModelAndView boardList(@ModelAttribute("search") BoardSearch search) {
        ModelAndView mav = new ModelAndView("board/list");
        int total = boardService.selectBoardCount();
        search.setTotalCount(total);
        search.makePagination();
        List<Board> boardList = boardService.selectBoard(search);
        mav.addObject("boardList", boardList);
        mav.addObject("total", total);
        return mav;
    }
}
