package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MyEntitySub extends PanacheEntity {
    public String field;

    @ManyToMany
    public Set<MyEntitySub> subSet = new HashSet<>();
}
