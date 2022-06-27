package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class MyEntity extends PanacheEntity {

    public String field;

    @ManyToMany()
    @JoinTable(name = "foo_foo")
    public Set<MyEntitySub> subSet = new HashSet<>();
}
