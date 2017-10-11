package web.controllers;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;


public interface VstoryControlInterface<T> {
    String getAll(Model model);
    void create(String searchKey,T object);
    T get(String searchKey);
    void update(HttpServletRequest request, Model model);
    void delete(String searchKey);
}
