package com.hugoulloa.foro_hub.service;

import com.hugoulloa.foro_hub.dto.TopicoRequestDTO;
import com.hugoulloa.foro_hub.model.Topico;
import com.hugoulloa.foro_hub.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public Topico crear(TopicoRequestDTO dto) {
        Topico t = new Topico();
        t.setTitulo(dto.titulo());
        t.setMensaje(dto.mensaje());
        return repository.save(t);
    }

    public List<Topico> listar() {
        return repository.findAll();
    }

    public Topico buscar(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Topico actualizar(Long id, TopicoRequestDTO dto) {
        Topico t = buscar(id);
        t.setTitulo(dto.titulo());
        t.setMensaje(dto.mensaje());
        return repository.save(t);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}