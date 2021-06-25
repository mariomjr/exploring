package br.com.elo7.exploring.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SpaceCreateDTO {

    @NotNull(message = "xLimit is required")
    private Integer xLimit;

    @NotNull(message = "yLimit is required")
    private Integer yLimit;

    @Valid
    @NotEmpty
    private List<SpacecraftCreateDTO> spacecraftList;

}
