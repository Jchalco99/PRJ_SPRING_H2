package com.tecsup.demo.aop;

import com.tecsup.demo.domain.entities.Auditoria;
import com.tecsup.demo.domain.entities.Rifa;
import com.tecsup.demo.domain.entities.Sede;
import com.tecsup.demo.domain.persistance.AuditoriaDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;

@Component
@Aspect
public class LogginAspecto {

    private Long tx;

    @Autowired
    private AuditoriaDao auditoriaDao;

    @Around("execution(* com.tecsup.demo.services.*ServiceImpl.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result =  null;
        Long currTime = System.currentTimeMillis();
        tx = System.currentTimeMillis();
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String metodo = "tx[" + tx + "] - " + joinPoint.getSignature().getName();
        //logger.info(metodo + "()");
        if(joinPoint.getArgs().length > 0)
            logger.info(metodo + "() INPUT:" + Arrays.toString(joinPoint.getArgs()));
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            logger.error(e.getMessage());
        }
        logger.info(metodo + "(): tiempo transcurrido " + (System.currentTimeMillis() - currTime) + " ms.");
        return result;
    }

    @After("execution(* com.tecsup.demo.controllers.SedeController.guardar*(..)) ||" +
            "execution(* com.tecsup.demo.controllers.SedeController.editar*(..)) ||" +
            "execution(* com.tecsup.demo.controllers.SedeController.eliminar*(..))")
    public void auditoriaSede(JoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String metodo = joinPoint.getSignature().getName();
        Integer id = null;
        String tabla = "sedes";

        Object[] parametros = joinPoint.getArgs();

        if (metodo.startsWith("guardar")) {
            if (parametros[0] instanceof Sede) {
                Sede sede = (Sede) parametros[0];
                id = sede.getId();
            }
        } else if (metodo.startsWith("editar")) {
            if (parametros[0] instanceof Integer) {
                id = (Integer) parametros[0];
            }
        } else if (metodo.startsWith("eliminar")) {
            if (parametros[0] instanceof Integer) {
                id = (Integer) parametros[0];
            }
        }

        String traza = "tx[" + tx + "] - " + metodo;
        logger.info(traza + "(): registrando auditoria...");
        auditoriaDao.save(new Auditoria(tabla, id, Calendar.getInstance().getTime(), "usuario", metodo));
    }

    @After("execution(* com.tecsup.demo.controllers.RifaController.guardar*(..)) ||" +
            "execution(* com.tecsup.demo.controllers.RifaController.editar*(..)) ||" +
            "execution(* com.tecsup.demo.controllers.RifaController.eliminar*(..))")
    public void auditoriaRifa(JoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String metodo = joinPoint.getSignature().getName();
        Integer id = null;
        String tabla = "rifas";

        Object[] parametros = joinPoint.getArgs();

        if (metodo.startsWith("guardar")) {
            if (parametros[0] instanceof Rifa) {
                Rifa rifa = (Rifa) parametros[0];
                id = rifa.getId();
            }
        } else if (metodo.startsWith("editar")) {
            if (parametros[0] instanceof Integer) {
                id = (Integer) parametros[0];
            }
        } else if (metodo.startsWith("eliminar")) {
            if (parametros[0] instanceof Integer) {
                id = (Integer) parametros[0];
            }
        }

        String traza = "tx[" + tx + "] - " + metodo;
        logger.info(traza + "(): registrando auditoria...");
        auditoriaDao.save(new Auditoria(tabla, id, Calendar.getInstance().getTime(), "usuario", metodo));
    }

}
