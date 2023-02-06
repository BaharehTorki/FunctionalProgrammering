package org.example.service;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface PrintInterface<T> {
    PrintForm<?> getPrintForm();

}
