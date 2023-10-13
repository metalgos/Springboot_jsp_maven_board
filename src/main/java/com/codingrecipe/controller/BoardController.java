package com.codingrecipe.controller;

import com.codingrecipe.dto.BoardDTO;
import com.codingrecipe.dto.PageDTO;
import com.codingrecipe.mapper.BoardMapper;
import com.codingrecipe.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardlist";
    }
    @GetMapping("/save")
    public String saveForm() {
        return "boardsave";
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDTO) {
        int saveResult = boardService.save(boardDTO);
        if (saveResult > 0) {
            return "redirect:/board/paging";
        } else {
            return "boardsave";
        }
    }

    @GetMapping
    public String findById(@RequestParam("id") Long id,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           Model model) {
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        model.addAttribute("page", page);
        //List<CommentDTO> commentDTOList = commentService.findAll(id);
       // model.addAttribute("commentList", commentDTOList);
        return "boarddetail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        boardService.delete(id);
        return "redirect:/board/";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardupdate";
    }

    @PostMapping("/update")
    public String update(BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "boarddetail";
//        return "redirect:/board?id="+boardDTO.getId();
    }


    @GetMapping("/paging")
    public String paging(Model model,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        System.out.println("page = " + page);
        // 해당 페이지에서 보여줄 글 목록
        List<BoardDTO> pagingList = boardService.pagingList(page);
        System.out.println("pagingList = " + pagingList);
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
        return "paging";
    }


}
