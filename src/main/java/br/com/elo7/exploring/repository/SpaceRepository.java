package br.com.elo7.exploring.repository;

import br.com.elo7.exploring.entity.Space;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SpaceRepository extends CrudRepository<Space, Integer> {

}
