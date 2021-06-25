package br.com.elo7.exploring.mappers;

import br.com.elo7.exploring.entity.Space;
import br.com.elo7.exploring.model.SpaceViewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SpaceViewMapper {

    SpaceViewMapper INSTANCE = Mappers.getMapper(SpaceViewMapper.class);
	
    SpaceViewDTO toDto(Space source);

    List<SpaceViewDTO> toDto(List<Space> source);

}
