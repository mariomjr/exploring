package br.com.elo7.exploring.model;

import lombok.Data;

import java.util.List;

@Data
public class SpaceViewDTO {

    private Integer id;

    private Integer xLimit;

    private Integer yLimit;

    private List<SpacecraftViewDTO> spacecraftList;

}
