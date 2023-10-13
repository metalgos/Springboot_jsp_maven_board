package com.codingrecipe.mapper;

import com.codingrecipe.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public int save(MemberDTO memberDTO);


    public MemberDTO findByMemberEmail(String loginEmail);
    public MemberDTO login(MemberDTO memberDTO);

}
