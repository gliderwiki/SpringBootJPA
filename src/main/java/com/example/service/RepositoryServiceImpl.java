package com.example.service;

import com.example.entity.Member;
import com.example.entity.Team;
import com.example.repository.MemberRepository;
import com.example.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RepositoryServiceImpl implements RepositoryService {

	Logger logger = LoggerFactory.getLogger(RepositoryServiceImpl.class);

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private TeamRepository teamRepository;

	public void saveMember() {
		Team team1 = new Team("발리팀");
		Team team2 = new Team("흑산도");
		Team team3 = new Team("이어도");

		Member first = new Member(team2, "이남희");

		teamRepository.save(team1);
		teamRepository.save(team2);
		teamRepository.save(team3);
		memberRepository.save(first);
	}

	@Transactional // Team 의 내부 컬랙션이 Lazy 전략이기 때문에 Transactional 이 적용 되어야 한다.
	public void print() {
		List<Team> teams = teamRepository.findAll();

		for (Team team : teams) {
			System.out.printf("#####################################");
			System.out.println("## team = " + team);

			for (Member lazyMember : team.getMember()) {
				System.out.println("-----------------------------------");
				System.out.println("## lazyMember : " + lazyMember);
			}
		}
	}

	public void lazyEntityPrint() {
		// Lazy 엔티티를 호출하지 않으므로 @Transactional 어노테이션이 없어도 된다.
		List<Member> member = memberRepository.findAll();
		for (Member lazyMember : member) {
			System.out.println("===============================");
			System.out.println("## lazyMember : " + lazyMember);
		}
	}

	public void deletConstraintKey() {
		// team과 member간에 양방향 관계 constraint 를 삭제하기 위해 team을 지워준다.
		// member 는 부모의 키가 삭제 될때 같이 삭제 되어야 한다.
		teamRepository.deleteAll();
		System.out.println("@@@@@@ 삭제 완료");
	}

}