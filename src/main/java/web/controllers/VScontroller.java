package web.controllers;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface VScontroller{
    String getAll(Model model);
    String update(HttpServletRequest request);
    String delete(String uuid);
}
