package fr.kira.formation.spring.democrud.demo;

import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DemoFunctionalInterface {

    public void mtd(){
        MaFonction foo = (a, b) -> a+b;
        foo.calcul(4,5);

        Stream.of(1,2,3).map(val->val*2);
    }
}
