package com.elianachv.HoraEnInglesBack.service;

import com.elianachv.HoraEnInglesBack.exception.TipoDeArchivoIncorrectoException;
import com.elianachv.HoraEnInglesBack.model.HoraEnIngles;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@RunWith(MockitoJUnitRunner.class)
public class HoraEnInglesServiceImplTest {
    @InjectMocks
    HoraEnInglesServiceImpl horaEnInglesService;

    @Test
    public void consultarHoraEnInglesCorrectamente() throws IOException, TipoDeArchivoIncorrectoException {

        String test = "5\n45";
        ArrayList<HoraEnIngles> result = horaEnInglesService.consultarHoraEnIngles(generarArchivoMultipart(test));

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("quarter to six", result.get(0).getResultado());

    }

    @Test
    public void consultar2HorasEnInglesCorrectamente() throws IOException, TipoDeArchivoIncorrectoException {

        String test = "5\n45\n3\n00";
        ArrayList<HoraEnIngles> result = horaEnInglesService.consultarHoraEnIngles(generarArchivoMultipart(test));

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("quarter to six", result.get(0).getResultado());
        Assertions.assertEquals("three o' clock", result.get(1).getResultado());


    }

    @Test(expected = NoSuchElementException.class)
    public void consultar2HorasEnInglesGeneraError() throws IOException, TipoDeArchivoIncorrectoException {

        String test = "5\n45\n3";
        ArrayList<HoraEnIngles> result = horaEnInglesService.consultarHoraEnIngles(generarArchivoMultipart(test));




    }

    private MultipartFile generarArchivoMultipart(String contenido) {
        String name = "file.txt";
        String originalFileName = "file.txt";
        String contentType = "text/plain";
        return new MockMultipartFile(name, originalFileName, contentType, contenido.getBytes());
    }
}