package com.hugoulloa.foro_hub.controller;

import com.hugoulloa.foro_hub.model.Respuesta;
import com.hugoulloa.foro_hub.model.Topico;
import com.hugoulloa.foro_hub.repository.RespuestaRepository;
import com.hugoulloa.foro_hub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos/{id}/respuestas")
public class RespuestaController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping
    public Respuesta responder(
            @PathVariable Long id,
            @RequestBody Respuesta respuesta) {

        Topico topico = topicoRepository.getReferenceById(id);
        respuesta.setTopico(topico);

        return respuestaRepository.save(respuesta);
    }
}
