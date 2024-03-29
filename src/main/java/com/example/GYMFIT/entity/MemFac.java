package com.example.GYMFIT.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "memFac")
@Table(name="memFac")
@Getter
@Setter
@ToString
public class MemFac {
    @Id
    @Column(name = "mem_fac_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memFacId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @Column(nullable = false)
    private int totalPrice;



    public static MemFac createMemfac(Member member, Facility facility){
        MemFac memFac = new MemFac();
        memFac.setMember(member);
        memFac.setFacility(facility);
        memFac.setTotalPrice(facility.getFacilityPrice());
        return memFac;
    }


}
