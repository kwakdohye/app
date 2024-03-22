package com.example.GYMFIT.repository;


import com.example.GYMFIT.entity.Member;
import org.hibernate.metamodel.internal.MemberResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long>, QuerydslPredicateExecutor<Member>, MemberRepositoryCustom {
    List<Member> findByMemNm(String memNm);
    List<Member> findByMemId(Long memId);

}
