package com.codingrecipe.mapper;

import com.codingrecipe.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public int save(MemberDTO memberDTO);
    public List<MemberDTO> findAll();
    public MemberDTO findById(Long id);

    public MemberDTO findByMemberEmail(String loginEmail);
    public MemberDTO login(MemberDTO memberDTO);

    public int update(MemberDTO memberDTO);
    public void delete(Long id);

}
