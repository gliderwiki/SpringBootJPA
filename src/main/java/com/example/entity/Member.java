package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


/**
 * @Author : yion
 * @Date : 2015. 10. 29.
 * @Description :
 */
@Entity
public class Member {
    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seq;

    @Column(name = "name")
    private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "team_seq")  // @ManyToOne의 fetch 기본전략은 EAGER이다.
	private Team team;

	public Member() {
	}

	public Member(Team team, String name) {
		this.team = team;
		this.name = name;
	}

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
    public String toString() {
        String result = "[member_" + seq + "] : " + name;
        return result;
    }

}
