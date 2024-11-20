package lt.techin.jparelationships.onetoone.simplepk.service;

import lt.techin.jparelationships.onetoone.simplepk.model.Team;

public interface TeamService {

    Team validateAndGetTeam(Long id);

    Team saveTeam(Team team);

    void deleteTeam(Team team);
}
