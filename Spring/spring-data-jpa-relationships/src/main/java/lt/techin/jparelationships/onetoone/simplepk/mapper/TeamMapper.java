package lt.techin.jparelationships.onetoone.simplepk.mapper;

import lt.techin.jparelationships.onetoone.simplepk.model.Team;
import lt.techin.jparelationships.onetoone.simplepk.model.TeamDetail;
import lt.techin.jparelationships.onetoone.simplepk.rest.dto.CreateTeamDetailRequest;
import lt.techin.jparelationships.onetoone.simplepk.rest.dto.CreateTeamRequest;
import lt.techin.jparelationships.onetoone.simplepk.rest.dto.TeamResponse;
import lt.techin.jparelationships.onetoone.simplepk.rest.dto.UpdateTeamDetailRequest;
import lt.techin.jparelationships.onetoone.simplepk.rest.dto.UpdateTeamRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TeamMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teamDetail", ignore = true)
    Team toTeam(CreateTeamRequest createTeamRequest);

    TeamResponse toTeamResponse(Team team);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teamDetail", ignore = true)
    void updateTeamFromRequest(UpdateTeamRequest updateTeamRequest, @MappingTarget Team team);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", ignore = true)
    TeamDetail toTeamDetail(CreateTeamDetailRequest createTeamDetailRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", ignore = true)
    void updateTeamDetailFromRequest(UpdateTeamDetailRequest updateTeamDetailRequest,
                                     @MappingTarget TeamDetail teamDetail);
}
