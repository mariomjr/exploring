package br.com.elo7.exploring.model;

import br.com.elo7.exploring.enums.Direction;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class SpacecraftCreateDTO {

    @NotNull(message = "xPosInit is required")
    private Integer xPosInit;

    @NotNull(message = "yPosInit is required")
    private Integer yPosInit;

    @NotNull(message = "directionInit is required")
    private Direction directionInit;

    @NotNull(message = "commands is required")
    @Pattern(regexp = "(M|L|R)+")
    private String commands;
}
