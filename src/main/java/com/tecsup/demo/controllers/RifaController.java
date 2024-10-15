package com.tecsup.demo.controllers;

import com.tecsup.demo.domain.entities.Rifa;
import com.tecsup.demo.services.RifaService;
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
@SessionAttributes("rifa")
public class RifaController {
    @Autowired
    private RifaService rifaService;
    @Autowired
    private SedeService sedeService;

    @RequestMapping(value = "/listarRifas", method = RequestMethod.GET)
    public String listarRifas(Model model) {
        model.addAttribute("rifas", rifaService.listar());
        return "rifa/listar"; // Vistas en la carpeta "rifa"
    }

    @RequestMapping(value = "/formRifa")
    public String crear(Map<String, Object> model) {
        Rifa rifa = new Rifa();
        model.put("rifa", rifa);
        model.put("sedes", sedeService.listar()); // Agrega la lista de sedes al modelo
        return "rifa/form"; // Vistas en la carpeta "rifa"
    }

    @RequestMapping(value = "/formRifa", method = RequestMethod.POST)
    public String guardar(@Valid Rifa rifa, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("sedes", sedeService.listar()); // Reagrega la lista de sedes si hay errores
            return "rifa/form"; // Vistas en la carpeta "rifa"
        }
        rifaService.grabar(rifa);
        status.setComplete();
        return "redirect:listarRifas";
    }

    @RequestMapping(value = "/formRifa/{id}")
    public String editar(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Rifa rifa = null;

        if (id > 0) {
            rifa = rifaService.buscar(id);
        } else {
            return "redirect:/listarRifas";
        }

        model.put("rifa", rifa);
        model.put("sedes", sedeService.listar()); // Agrega la lista de sedes al modelo
        return "rifa/form"; // Vistas en la carpeta "rifa"
    }

    @RequestMapping(value = "/eliminarRifa/{id}")
    public String eliminar(@PathVariable(value = "id") Integer id) {
        if (id > 0) {
            rifaService.eliminar(id);
        }
        return "redirect:/listarRifas";
    }

    @RequestMapping(value="/verRifas")
    public String verRifas(Model model) {
        model.addAttribute("rifas", rifaService.listar());
        model.addAttribute("titulo", "Lista de Rifas");

        return "rifa/ver";
    }
}
