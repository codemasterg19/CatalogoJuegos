package com.spring_app.Controlador;

import com.spring_app.Servicio.PdfServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PdfControlador {

    @Autowired
    PdfServicio pdfServicio;

    @GetMapping("/factura/pdf")
    public ResponseEntity<byte[]> descargarPdf() throws Exception {
        byte[] pdf = pdfServicio.generarPdf();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "factura.pdf");
        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }

}
