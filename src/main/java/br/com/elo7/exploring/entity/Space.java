package br.com.elo7.exploring.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "SPACE")
public class Space implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SPACE")
    @SequenceGenerator(name="SEQ_SPACE", sequenceName="SEQ_SPACE", allocationSize = 1)
    private Integer id;

    private Integer xLimit;

    private Integer yLimit;

    @OneToMany(mappedBy = "space", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Spacecraft> spacecraftList;

}
