package com.cegeka.springcourse.filters;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class MemberRepository {

    private List<String> memberIds = new ArrayList();

    public MemberRepository(){
        memberIds.add("SKING");
        memberIds.add("MATWOOD");
        memberIds.add("LGROSSMAN");
    }

    public List<String> getMembers() {
        return memberIds;
    }
}
