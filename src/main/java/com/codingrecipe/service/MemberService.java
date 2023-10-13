package com.codingrecipe.service;

import com.codingrecipe.dto.MemberDTO;
import com.codingrecipe.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    public int save(MemberDTO memberDTO) {
        return memberMapper.save(memberDTO);
    }

    public List<MemberDTO> findAll() {
        return memberMapper.findAll();
    }

    public MemberDTO findById(Long id) {
        return memberMapper.findById(id);
    }


    public boolean login(MemberDTO memberDTO) {
        if (memberMapper.login(memberDTO) != null) {
            return true;
        } else {
            return false;
        }
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        return memberMapper.findByMemberEmail(loginEmail);
    }

    public boolean update(MemberDTO memberDTO) {
        int result =  memberMapper.update(memberDTO);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void delete(Long id) {
        memberMapper.delete(id);
    }

    public String emailCheck(String memberEmail) {

        if (memberMapper.findByMemberEmail(memberEmail) == null) {
            return "ok";
        } else {
            return "no";
        }
    }

}
