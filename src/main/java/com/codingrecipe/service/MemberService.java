package com.codingrecipe.service;

import com.codingrecipe.dto.MemberDTO;
import com.codingrecipe.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;


    public String emailCheck(String memberEmail) {

        if (memberMapper.findByMemberEmail(memberEmail) == null) {
            return "ok";
        } else {
            return "no";
        }
    }


}
