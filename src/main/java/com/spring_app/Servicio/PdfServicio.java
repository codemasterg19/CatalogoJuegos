package com.spring_app.Servicio;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring_app.Entidad.Factura;
import com.spring_app.Repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    public byte[] generarPdf() throws DocumentException, IOException {
        List<Factura> facturas = facturaRepositorio.findAll();
        Document document = new Document() {};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
        document.add(new Paragraph("Factura", FontFactory.getFont("Arial", 14, Font.BOLD)));
        PdfPTable table = new PdfPTable(5); // Cambiado de 3 a 5 columnas
        table.setWidthPercentage(100);
        table.addCell(new PdfPCell(new Phrase("Código", FontFactory.getFont("Arial", 12))));
        table.addCell(new PdfPCell(new Phrase("Número de Factura", FontFactory.getFont("Arial", 12))));
        table.addCell(new PdfPCell(new Phrase("Fecha", FontFactory.getFont("Arial", 12))));
        table.addCell(new PdfPCell(new Phrase("Precio Total", FontFactory.getFont("Arial", 12))));
        table.addCell(new PdfPCell(new Phrase("Nombre del Juego", FontFactory.getFont("Arial", 12))));
        for (Factura factura : facturas) {
            table.addCell(new PdfPCell(new Phrase(String.valueOf(factura.getId()), FontFactory.getFont("Arial", 12))));
            table.addCell(new PdfPCell(new Phrase(factura.getNumeroFactura(), FontFactory.getFont("Arial", 12))));
            table.addCell(new PdfPCell(new Phrase(factura.getFecha().toString(), FontFactory.getFont("Arial", 12))));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(factura.getPrecio_total()), FontFactory.getFont("Arial", 12))));
            table.addCell(new PdfPCell(new Phrase(factura.getJuego().getTitulo(), FontFactory.getFont("Arial", 12))));
        }
        document.add(table);
        document.close();
        return baos.toByteArray();
    }
}
