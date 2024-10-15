package com.tecsup.demo.views;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tecsup.demo.domain.entities.Sede;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Component("sede/ver")
public class SedePdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Sede> sedes = (List<Sede>) model.get("sedes");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = new PdfPCell(new Phrase("Lista de Sedes"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(3);
        tabla2.addCell("ID");
        tabla2.addCell("Nombre");
        tabla2.addCell("Ubicación");

        for (Sede sede : sedes) {
            tabla2.addCell(String.valueOf(sede.getId()));
            tabla2.addCell(sede.getNombre());
            tabla2.addCell(sede.getUbicacionMapa());
        }
        document.add(tabla);
        document.add(tabla2);
    }
}
