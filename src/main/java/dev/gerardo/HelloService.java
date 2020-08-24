package dev.gerardo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public String getSaludo(String nombre) {
        return "Hola " +nombre + "!";
    }
}
