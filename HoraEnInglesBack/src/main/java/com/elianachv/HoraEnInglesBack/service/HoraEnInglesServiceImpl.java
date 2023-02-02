package com.elianachv.HoraEnInglesBack.service;

import com.elianachv.HoraEnInglesBack.exception.TipoDeArchivoIncorrectoException;
import com.elianachv.HoraEnInglesBack.model.HoraEnIngles;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Service
public class HoraEnInglesServiceImpl implements HoraEnInglesService {

    @Override
    public ArrayList<HoraEnIngles> consultarHoraEnIngles(MultipartFile archivo) throws IOException, TipoDeArchivoIncorrectoException {
        Scanner scanner = new Scanner(configurarArchivo(archivo));
        return procesarData(configurarData(scanner));
    }

    private File configurarArchivo(MultipartFile archivo) throws IOException, TipoDeArchivoIncorrectoException {

        if (verificarTipoArchivo(archivo.getOriginalFilename())) {
            File doc = new File("info.txt");
            FileOutputStream fos = new FileOutputStream(doc);
            fos.write(archivo.getBytes());
            fos.close();
            return doc;
        } else {
            throw new TipoDeArchivoIncorrectoException("Tipo de archivo no permitido");
        }


    }

    private ArrayList<int[]> configurarData(Scanner scanner) {

        ArrayList<int[]> data = new ArrayList<>();
        while (scanner.hasNextLine()) {
            int[] par = new int[2];
            par[0] = scanner.nextInt();
            par[1] = scanner.nextInt();
            data.add(par);
        }

        imprimirData(data);
        return data;

    }

    private void traducirHora(HoraEnIngles horaEnIngles) {
        Map<Integer, String> HORAS_EN_INGLES = new HashMap<>();
        HORAS_EN_INGLES.put(0, "o' clock");
        HORAS_EN_INGLES.put(1, "one");
        HORAS_EN_INGLES.put(2, "two");
        HORAS_EN_INGLES.put(3, "three");
        HORAS_EN_INGLES.put(4, "four");
        HORAS_EN_INGLES.put(5, "five");
        HORAS_EN_INGLES.put(6, "six");
        HORAS_EN_INGLES.put(7, "seven");
        HORAS_EN_INGLES.put(8, "eigth");
        HORAS_EN_INGLES.put(9, "nine");
        HORAS_EN_INGLES.put(10, "ten");
        HORAS_EN_INGLES.put(11, "eleven");
        HORAS_EN_INGLES.put(12, "twelve");
        HORAS_EN_INGLES.put(13, "thirteen");
        HORAS_EN_INGLES.put(14, "fourteen");
        HORAS_EN_INGLES.put(15, "quarter");
        HORAS_EN_INGLES.put(16, "sixteen");
        HORAS_EN_INGLES.put(17, "sixteen");
        HORAS_EN_INGLES.put(18, "eigthteen");
        HORAS_EN_INGLES.put(19, "nineteen");
        HORAS_EN_INGLES.put(20, "twenty");
        HORAS_EN_INGLES.put(21, "twenty-one");
        HORAS_EN_INGLES.put(22, "twenty-two");
        HORAS_EN_INGLES.put(23, "twenty-three");
        HORAS_EN_INGLES.put(24, "twenty-four");
        HORAS_EN_INGLES.put(25, "twenty-five");
        HORAS_EN_INGLES.put(26, "twenty-six");
        HORAS_EN_INGLES.put(27, "twenty-seven");
        HORAS_EN_INGLES.put(28, "twenty-eight");
        HORAS_EN_INGLES.put(29, "twenty-nine");
        HORAS_EN_INGLES.put(30, "half");
        HORAS_EN_INGLES.put(31, "thirty-one");
        HORAS_EN_INGLES.put(32, "thirty-two");
        HORAS_EN_INGLES.put(33, "thirty-three");
        HORAS_EN_INGLES.put(34, "thirty-four");
        HORAS_EN_INGLES.put(35, "thirty-five");
        HORAS_EN_INGLES.put(36, "thirty-six");
        HORAS_EN_INGLES.put(37, "thirty-seven");
        HORAS_EN_INGLES.put(38, "thirty-eight");
        HORAS_EN_INGLES.put(39, "thirty-nine");


        int m = Integer.parseInt(horaEnIngles.getMinutos());
        int h = Integer.parseInt(horaEnIngles.getHora());
        String resultado;

        if (m == 0) {
            resultado = HORAS_EN_INGLES.get(h) + " " + HORAS_EN_INGLES.get(m);
        } else if (m == 15 || m == 30) {
            resultado = HORAS_EN_INGLES.get(m) + " past " + HORAS_EN_INGLES.get(h);
        } else if (m == 1) {
            resultado = HORAS_EN_INGLES.get(m) + " minute past " + HORAS_EN_INGLES.get(h);
        } else if (m < 40) {
            resultado = HORAS_EN_INGLES.get(m) + " minutes past " + HORAS_EN_INGLES.get(h);
        } else {

            int restante = 60 - m;

            if (restante == 15) {
                resultado = HORAS_EN_INGLES.get(restante) + " to " + HORAS_EN_INGLES.get(h + 1);
            } else if (restante == 1) {
                resultado = HORAS_EN_INGLES.get(restante) + " minute to " + HORAS_EN_INGLES.get(h + 1);
            } else {
                resultado = HORAS_EN_INGLES.get(restante) + " minutes to " + HORAS_EN_INGLES.get(h + 1);
            }
        }

        horaEnIngles.setResultado(resultado);
    }

    private ArrayList<HoraEnIngles> procesarData(ArrayList<int[]> data) {
        ArrayList<HoraEnIngles> respuesta = new ArrayList<>();

        data.forEach(d -> {
            HoraEnIngles horaEnIngles = new HoraEnIngles();
            horaEnIngles.setHora(formatearHora("HORA", d[0]));
            horaEnIngles.setMinutos(formatearHora("MINUTO", d[1]));
            traducirHora(horaEnIngles);
            respuesta.add(horaEnIngles);
        });

        return respuesta;
    }

    private void imprimirData(ArrayList<int[]> data) {
        data.forEach(d -> System.out.println(d[0] + ":" + d[1]));
    }

    private String formatearHora(String tipo, int valor) {

        String x = String.valueOf(valor);
        if (Objects.equals(tipo, "MINUTO")) {
            if (x.length() == 1) {
                x = "0" + x;
            }
        } else {
            x = valor == 0 ? "00" : x;
        }

        return x;

    }

    private boolean verificarTipoArchivo(String nombre) {
        String extension = "";
        int i = nombre.lastIndexOf('.');
        if (i > 0) {
            extension = nombre.substring(i + 1);
        }
        System.out.println("La extensiòn de archivo es : " + extension);

        return extension.equals("txt");
    }


}



