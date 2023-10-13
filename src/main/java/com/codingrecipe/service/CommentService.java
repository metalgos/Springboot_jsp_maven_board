package com.codingrecipe.service;

import com.codingrecipe.dto.CommentDTO;
import com.codingrecipe.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;

    public void save(CommentDTO commentDTO) {
        commentMapper.save(commentDTO);
    }

    public List<CommentDTO> findAll(Long boardId) {
        return commentMapper.findAll(boardId);
    }
}
