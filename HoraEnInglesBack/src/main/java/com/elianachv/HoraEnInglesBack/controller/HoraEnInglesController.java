package com.elianachv.HoraEnInglesBack.controller;

import com.elianachv.HoraEnInglesBack.exception.TipoDeArchivoIncorrectoException;
import com.elianachv.HoraEnInglesBack.model.HoraEnIngles;
import com.elianachv.HoraEnInglesBack.service.HoraEnInglesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@CrossOrigin("*")
public class HoraEnInglesController {

    @Autowired
    HoraEnInglesService horaEnInglesService;

    @PostMapping("/consultarHoraEnIngles")
    public ResponseEntity<ArrayList<HoraEnIngles>> consultarHoraEnIngles(@RequestParam("files") MultipartFile file) throws IOException, TipoDeArchivoIncorrectoException {
        return ResponseEntity.ok(horaEnInglesService.consultarHoraEnIngles(file));
    }


}

