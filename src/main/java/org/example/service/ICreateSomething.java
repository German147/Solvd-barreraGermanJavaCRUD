package org.example.service;

import java.util.List;

@FunctionalInterface
public interface ICreateSomething<T> {

    T createSomething();
}
