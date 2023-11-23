package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Cancion;
import com.example.demo.repository.CancionRepository;

@Service
@Transactional
public class CancionService {

    @Autowired
    CancionRepository songRepository;

    public List<Cancion> list(){
        return songRepository.findAll();
    }
    public Optional<Cancion> getOne(Long id){
        return songRepository.findById(id);
    }
    public Optional<Cancion> getByNombre(String nombre){
        return songRepository.findByNombre(nombre);
    }
    public void save (Cancion cancion){
        songRepository.save(cancion);
    }
    public void delete(Long id){
        songRepository.deleteById(id);
    }
    public boolean existsById(Long id){
        return songRepository.existsById(id);
    }
    public boolean existsByNombre(String nombre){
        return songRepository.existsByNombre(nombre);
    }

    public List<Cancion> buscarCanciones(String nombre, String artista, String genero) {
        if (nombre != null) {
            return songRepository.findByNombreContainingIgnoreCase(nombre);
        } else if (artista != null) {
            return songRepository.findByArtistaContainingIgnoreCase(artista);
        } else if (genero != null) {
            return songRepository.findByGeneroContainingIgnoreCase(genero);
        } else {
            return songRepository.findAll();
        }
    }

    
    /*
    public List<Cancion> buscarPorNombre(String nombre) {
        return songRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Cancion> buscarPorArtista(String artista) {
        return songRepository.findByArtistaContainingIgnoreCase(artista);
    }

    public List<Cancion> buscarPorGenero(String genero) {
        return songRepository.findByGeneroContainingIgnoreCase(genero);
    }
    */
    
    
}
