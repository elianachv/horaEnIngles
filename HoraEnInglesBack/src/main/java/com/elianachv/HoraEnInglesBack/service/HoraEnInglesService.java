package com.elianachv.HoraEnInglesBack.service;

import com.elianachv.HoraEnInglesBack.exception.TipoDeArchivoIncorrectoException;
import com.elianachv.HoraEnInglesBack.model.HoraEnIngles;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

public interface HoraEnInglesService {

    ArrayList<HoraEnIngles> consultarHoraEnIngles(MultipartFile filename) throws IOException, TipoDeArchivoIncorrectoException;


}
