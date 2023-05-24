package fr.kira.formation.spring.democrud.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class ControllerAspect {

    @Before("execution(* *..*Controller.*(..))")
    public void logBefore(JoinPoint jp){
        log.info("Appel de la méthode {} avec les paramètres {}",
                jp.getSignature().toShortString(), jp.getArgs());
    }

    @Before("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void logBeforeDelete(JoinPoint jp){
        log.warn("Appel d'une mehode DELETE {} avec les paramètres {}",
                jp.getSignature().toShortString(), jp.getArgs());
    }

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public Object logAroundGet(ProceedingJoinPoint jp) throws Throwable {
        log.info("avant");
        Object result = jp.proceed();
        log.info("après");
        return result;
    }
}
