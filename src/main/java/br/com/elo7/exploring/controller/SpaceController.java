package br.com.elo7.exploring.controller;

import br.com.elo7.exploring.entity.Space;
import br.com.elo7.exploring.exception.HandlerException;
import br.com.elo7.exploring.mappers.SpaceCreateMapper;
import br.com.elo7.exploring.mappers.SpaceViewMapper;
import br.com.elo7.exploring.model.SpaceCreateDTO;
import br.com.elo7.exploring.model.SpaceViewDTO;
import br.com.elo7.exploring.service.SpaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/space")
public class SpaceController extends HandlerException {

    private static final Logger LOG = LoggerFactory.getLogger(SpaceController.class);

    @Autowired
    private SpaceService spaceService;

    @ResponseBody
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "explore")
    public ResponseEntity<SpaceViewDTO> explore(@Valid @RequestBody SpaceCreateDTO spaceViewDTO){
        try {
            Space space = SpaceCreateMapper.INSTANCE.fromDto(spaceViewDTO);
            Space spaceUpdate = spaceService.explore(space);

            return new ResponseEntity<SpaceViewDTO>(
                    SpaceViewMapper.INSTANCE.toDto(spaceUpdate),
                    HttpStatus.ACCEPTED);
        }catch (Exception e){
            LOG.error("Erro ao explorar Marte: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpaceViewDTO>> findAll(){
        try {
            return new ResponseEntity<List<SpaceViewDTO>>(
                    SpaceViewMapper.INSTANCE.toDto(spaceService.findAll()),
                    HttpStatus.ACCEPTED);
        }catch (Exception e){
            LOG.error("Erro ao buscar: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
