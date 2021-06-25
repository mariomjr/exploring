package br.com.elo7.exploring.model;

import br.com.elo7.exploring.enums.Direction;
import lombok.Data;

@Data
public class SpacecraftViewDTO {

    private Integer xPosInit;

    private Integer yPosInit;

    private Direction directionInit;

    private String commands;

    private Integer xPosLast;

    private Integer yPosLast;

    private Direction directionLast;
}
