package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Q u i c K
 * Date : 2015-10-29
 * Description :
 */
@Entity
public class Team {

	@Id
	@Column(name = "seq")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seq;

	@Column(name = "team_name")
	private String teamName;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team", fetch = FetchType.LAZY) // @OneToMany의 fetch 기본전략은 LAZY이다.
	private Collection<Member> member;

	public Team() {
	}

	public Team(String teamName) {
		this.teamName = teamName;
	}


	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public Collection<Member> getMember() {
		if (member == null) {
			member = new ArrayList<Member>();
		}
		return member;
	}

	public void setMember(Collection<Member> member) {
		this.member = member;
	}

	public void addMember(Member member) {
		Collection<Member> members = getMember();
		members.add(member);
	}

	@Override
	public String toString() {
		String result = "[team_" + seq + "] : " + teamName;
		return result;
	}
}
