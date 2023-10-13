package com.codingrecipe.mapper;

import com.codingrecipe.dto.CommentDTO;

import java.util.List;

public interface CommentMapper {

    public void save(CommentDTO commentDTO);

    public List<CommentDTO> findAll(Long boardId);
}
