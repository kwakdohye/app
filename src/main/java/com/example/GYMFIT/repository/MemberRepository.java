package com.example.GYMFIT.repository;


import com.example.GYMFIT.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

}
