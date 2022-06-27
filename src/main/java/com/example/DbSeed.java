package com.example;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

@ApplicationScoped
public class DbSeed {
    @Transactional
    public void loadAdminUser(@Observes StartupEvent event) {
        var u = new MyEntity();
        u.field = "cool";
        u.persistAndFlush();
    }
}
