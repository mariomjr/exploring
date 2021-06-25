package br.com.elo7.exploring.entity;

import br.com.elo7.exploring.enums.Direction;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "SPACECRAFT")
public class Spacecraft implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SPACECRAFT")
    @SequenceGenerator(name="SEQ_SPACECRAFT", sequenceName="SEQ_SPACECRAFT", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private Space space;

    private Integer xPosInit;

    private Integer yPosInit;

    @Enumerated(EnumType.STRING)
    @Column(name = "DIRECTIONINIT", length = 1)
    private Direction directionInit;

    @Column(name = "COMMANDS", length = 255)
    private String commands;

    private Integer xPosLast;

    private Integer yPosLast;

    @Enumerated(EnumType.STRING)
    @Column(name = "DIRECTIONLAST", length = 1)
    private Direction directionLast;

}
