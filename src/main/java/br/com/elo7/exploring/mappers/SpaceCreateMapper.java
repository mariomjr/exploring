package br.com.elo7.exploring.mappers;

import br.com.elo7.exploring.entity.Space;
import br.com.elo7.exploring.model.SpaceCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SpaceCreateMapper {

    SpaceCreateMapper INSTANCE = Mappers.getMapper(SpaceCreateMapper.class);

    Space fromDto(SpaceCreateDTO source);

}
