package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ManagerRepository;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

@Autowired
private ManagerRepository managerRepository;
}
