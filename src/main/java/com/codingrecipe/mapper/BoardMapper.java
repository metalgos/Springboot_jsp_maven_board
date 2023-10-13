package com.codingrecipe.mapper;

import com.codingrecipe.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    public int save(BoardDTO boardDTO);

    public List<BoardDTO> findAll();

    public BoardDTO findById(Long id);

    public void updateHits(Long id);

    public void delete(Long id);

    public void update(BoardDTO boardDTO);

    public List<BoardDTO> pagingList(Map<String, Integer> pagingParams);

    public int boardCount();
}
