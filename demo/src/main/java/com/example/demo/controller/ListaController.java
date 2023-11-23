package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ListaDto;
import com.example.demo.dto.Mensaje;
import com.example.demo.entity.Cancion;
import com.example.demo.entity.Lista;
import com.example.demo.service.CancionService;
import com.example.demo.service.ListaService;

import io.micrometer.core.instrument.util.StringUtils;

@RestController
@RequestMapping("/lista")
@CrossOrigin(origins = "http://localhost:4200")
public class ListaController {

    @Autowired
    ListaService lisService;
    @Autowired
    CancionService cancionesService;

    @GetMapping("/listas")
    public ResponseEntity<List<Lista>> list() {
        List<Lista> list = lisService.list();
        return new ResponseEntity<List<Lista>>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Lista> getById(@PathVariable("id") Long id) {
        if (!lisService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Lista song = lisService.getOne(id).get();
        return new ResponseEntity(song, HttpStatus.OK);
    }

    @GetMapping("/detailgenero/genero")
    public ResponseEntity<Lista> getByNombre(@PathVariable("genero") String genero) {
        if (!lisService.existsByGenero(genero)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Lista song = lisService.getByGenero(genero).get();
        return new ResponseEntity(song, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ListaDto songDto) {
        if (StringUtils.isBlank(songDto.getGenero())) {
            return new ResponseEntity(new Mensaje("El genero es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Lista song = new Lista(songDto.getGenero(), songDto.getCanciones());
        lisService.save(song);
        return new ResponseEntity(new Mensaje("Genero creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ListaDto songDto) {
        if (!lisService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(songDto.getGenero())) {
            return new ResponseEntity(new Mensaje("El genero es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Lista song = lisService.getOne(id).get();
        song.setGenero(songDto.getGenero());
        song.setCanciones(songDto.getCanciones());
        lisService.save(song);
        return new ResponseEntity(new Mensaje("Genero actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!lisService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No se encontró el genero con el ID " + id), HttpStatus.NOT_FOUND);
        }
        lisService.delete(id);
        return new ResponseEntity(new Mensaje("Genero borrada"), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/cancionesPorLista/{id}")
    public ResponseEntity<List<Cancion>> getCancionesPorLista(@PathVariable("id") Long id) {
        List<Lista> listas = lisService.list();
        Optional<Lista> listaOpt = listas.stream().filter(lista -> lista.getId().equals(id)).findFirst();

        if (listaOpt.isPresent()) {
            List<Cancion> canciones = listaOpt.get().getCanciones();
            return new ResponseEntity<>(canciones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
