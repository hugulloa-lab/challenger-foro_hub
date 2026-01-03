package com.hugoulloa.foro_hub.controller;

import com.hugoulloa.foro_hub.model.Topico;
import com.hugoulloa.foro_hub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<Topico> crear(@RequestBody Topico topico) {
        Topico guardado = repository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    // ✅ READ (LIST)
    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }

    // ✅ DELETE
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ UPDATE (PUT)
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizar(
            @PathVariable Long id,
            @RequestBody Topico datosActualizados) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Topico topico = repository.findById(id).get();

        topico.setTitulo(datosActualizados.getTitulo());
        topico.setMensaje(datosActualizados.getMensaje());

        return ResponseEntity.ok(topico);
    }
}
