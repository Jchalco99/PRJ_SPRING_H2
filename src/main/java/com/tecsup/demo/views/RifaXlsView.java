package com.tecsup.demo.views;

import com.tecsup.demo.domain.entities.Rifa;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import java.util.List;
import java.util.Map;

@Component("rifa/ver.xlsx")
public class RifaXlsView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"rifa_view.xlsx\"");
        List<Rifa> rifas = (List<Rifa>) model.get("rifas");
        Sheet sheet = workbook.createSheet("Lista de Rifas");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Lista de Rifas");

        Row header = sheet.createRow(4);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Nombre de la Rifa");
        header.createCell(2).setCellValue("Fecha");
        header.createCell(3).setCellValue("Precio del Boleto");
        header.createCell(4).setCellValue("Cantidad de Boletos");

        int rownum = 6;

        for (Rifa rifa : rifas) {
            Row fila = sheet.createRow(rownum++);
            fila.createCell(0).setCellValue(rifa.getId());
            fila.createCell(1).setCellValue(rifa.getNombre());
            fila.createCell(2).setCellValue(rifa.getFechaRifa().toString());
            fila.createCell(3).setCellValue(rifa.getPrecioBoleto());
            fila.createCell(4).setCellValue(rifa.getCantidadBoleto());
        }
    }
}
