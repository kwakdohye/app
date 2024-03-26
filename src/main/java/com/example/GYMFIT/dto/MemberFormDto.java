package com.example.GYMFIT.dto;

import com.example.GYMFIT.entity.Member;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter

public class MemberFormDto {
    private Long memId;
    private String memNm;
    private String memBirthDt;
    private String memCno;
    private String memAdr;
    private String memEmlAdr;
    private String memRgtDt;

    private static ModelMapper modelMapper = new ModelMapper();
    public Member createMember(){
        return modelMapper.map(this, Member.class);
    }
    public static MemberFormDto of (Member member){return modelMapper.map(member, MemberFormDto.class);
    }


}
