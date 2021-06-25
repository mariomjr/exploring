package br.com.elo7.exploring.service;

import br.com.elo7.exploring.entity.Space;
import br.com.elo7.exploring.entity.Spacecraft;
import br.com.elo7.exploring.enums.Direction;
import br.com.elo7.exploring.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class SpaceService {

    @Autowired
    SpaceRepository spaceRepository;

    public List<Space> findAll(){
        return StreamSupport
                .stream(spaceRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Space explore(Space space) {

        space.getSpacecraftList()
                .stream()
                .forEach(sp->calculatePosSpacecraft(sp, space));

        space.getSpacecraftList()
                .parallelStream()
                .forEach(spacecraft -> spacecraft.setSpace(space));
        spaceRepository.save(space);

        return space;
    }

    /**
     * Calcula movimento e direçao final da sonda
     * @param spacecraft
     * @param space
     */
    private void calculatePosSpacecraft(Spacecraft spacecraft, Space space) {
        Direction direction = spacecraft.getDirectionInit();
        spacecraft.setXPosLast(spacecraft.getXPosInit());
        spacecraft.setYPosLast(spacecraft.getYPosInit());

        for(String cmd : spacecraft.getCommands().split("")){
            if(cmd.equals("L") || cmd.equals("R")){
                direction = nextDirection(cmd, direction);
            }else{
                moveSpacecraft(direction, spacecraft, space);
            }
        }
        spacecraft.setDirectionLast(direction);
    }

    /**
     * Movimenta a sonda pelo plano
     * @param direction
     * @param spacecraft
     * @param space
     */
    private void moveSpacecraft(Direction direction, Spacecraft spacecraft, Space space) {

        switch (direction){
            case N:
                spacecraft.setYPosLast(calculatePosLimit(spacecraft.getYPosLast(), 1, space.getYLimit()));
                break;
            case W:
                spacecraft.setXPosLast(calculatePosLimit(spacecraft.getXPosLast(), -1, space.getXLimit()));
                break;
            case S:
                spacecraft.setYPosLast(calculatePosLimit(spacecraft.getYPosLast(), -1, space.getYLimit()));
                break;
            case E:
                spacecraft.setXPosLast(calculatePosLimit(spacecraft.getXPosLast(), 1, space.getXLimit()));
                break;
        }
    }

    /**
     * Validando limite do plano
     * @param lastPosition
     * @param valueAdd
     * @param limit
     * @return
     */
    private Integer calculatePosLimit(Integer lastPosition, Integer valueAdd, Integer limit){
        Integer value = lastPosition + valueAdd;
        if(value > limit || value<0 ){
            return lastPosition;
        }
        return value;
    }

    /**
     * Retorna proxima direção
     * @param cmd
     * @param direction
     * @return
     */
    private Direction nextDirection(String cmd, Direction direction) {
        switch (cmd){
            case "L":
                return rotateLeft(direction);
            case "R":
                return rotateRigth(direction);
            default:
                return direction;
        }
    }

    private Direction rotateLeft(Direction direction) {
        switch (direction) {
            case N:
                return Direction.W;
            case W:
                return Direction.S;
            case S:
                return Direction.E;
            case E:
                return Direction.N;
            default:
                return direction;
        }
    }

    private Direction rotateRigth(Direction direction) {
        switch (direction) {
            case N:
                return Direction.E;
            case E:
                return Direction.S;
            case S:
                return Direction.W;
            case W:
                return Direction.N;
            default:
                return direction;
        }
    }


}
