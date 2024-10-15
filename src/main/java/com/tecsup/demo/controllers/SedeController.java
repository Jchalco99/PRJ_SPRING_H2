package com.tecsup.demo.controllers;

import com.tecsup.demo.domain.entities.Sede;
import com.tecsup.demo.services.SedeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("sede")
public class SedeController {
    @Autowired
    private SedeService sedeService;

    @RequestMapping(value = "/listarSedes", method = RequestMethod.GET)
    public String listarSedes(Model model) {
        model.addAttribute("sedes", sedeService.listar());
        return "sede/listar"; // Vistas en la carpeta "sede"
    }

    @RequestMapping(value = "/formSede")
    public String crear(Map<String, Object> model) {
        Sede sede = new Sede();
        model.put("sede", sede);
        return "sede/form"; // Vistas en la carpeta "sede"
    }

    @RequestMapping(value = "/formSede", method = RequestMethod.POST)
    public String guardar(@Valid Sede sede, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "sede/form"; // Vistas en la carpeta "sede"
        }
        sedeService.grabar(sede);
        status.setComplete();
        return "redirect:listarSedes";
    }

    @RequestMapping(value = "/formSede/{id}")
    public String editar(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Sede sede = null;

        if (id > 0) {
            sede = sedeService.buscar(id);
        } else {
            return "redirect:/listarSedes";
        }
        model.put("sede", sede);
        return "sede/form"; // Vistas en la carpeta "sede"
    }

    @RequestMapping(value = "/eliminarSede/{id}")
    public String eliminar(@PathVariable(value = "id") Integer id) {
        if (id > 0) {
            sedeService.eliminar(id);
        }
        return "redirect:/listarSedes";
    }

    @RequestMapping(value="/verSedes")
    public String verSedes(Model model) {
        model.addAttribute("sedes", sedeService.listar());
        model.addAttribute("titulo", "Lista de Sedes");

        return "sede/ver";
    }
}
