package com.tecsup.demo.views;

import com.tecsup.demo.domain.entities.Sede;
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

@Component("sede/ver.xlsx")
public class SedeXlsView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"sede_view.xlsx\"");
        List<Sede> sedes = (List<Sede>) model.get("sedes");
        Sheet sheet = workbook.createSheet("Lista de Sedes");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Lista de Sedes");

        Row header = sheet.createRow(4);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Nombre");
        header.createCell(2).setCellValue("Ubicación");

        int rownum = 6;

        for (Sede sede : sedes) {
            Row fila = sheet.createRow(rownum++);
            fila.createCell(0).setCellValue(sede.getId());
            fila.createCell(1).setCellValue(sede.getNombre());
            fila.createCell(2).setCellValue(sede.getUbicacionMapa());
        }
    }
}
