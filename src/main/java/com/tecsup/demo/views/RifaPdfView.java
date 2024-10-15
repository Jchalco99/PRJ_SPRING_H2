package com.tecsup.demo.views;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tecsup.demo.domain.entities.Rifa;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Component("rifa/ver")
public class RifaPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Rifa> rifas = (List<Rifa>) model.get("rifas");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = new PdfPCell(new Phrase("Lista de Rifas"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(5);
        tabla2.addCell("ID");
        tabla2.addCell("Nombre de la Rifa");
        tabla2.addCell("Fecha");
        tabla2.addCell("Precio del Boleto");
        tabla2.addCell("Cantidad de Boletos");

        for (Rifa rifa : rifas) {
            tabla2.addCell(String.valueOf(rifa.getId()));
            tabla2.addCell(rifa.getNombre());
            tabla2.addCell(rifa.getFechaRifa().toString());
            tabla2.addCell(String.valueOf(rifa.getPrecioBoleto()));
            tabla2.addCell(String.valueOf(rifa.getCantidadBoleto()));
        }
        document.add(tabla);
        document.add(tabla2);
    }
}

