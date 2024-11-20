package lt.techin.jparelationships.onetoone.simplepk.service;

import lt.techin.jparelationships.onetoone.simplepk.exception.TeamNotFoundException;
import lt.techin.jparelationships.onetoone.simplepk.model.Team;
import lt.techin.jparelationships.onetoone.simplepk.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public Team validateAndGetTeam(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Team team) {
        teamRepository.delete(team);
    }
}
