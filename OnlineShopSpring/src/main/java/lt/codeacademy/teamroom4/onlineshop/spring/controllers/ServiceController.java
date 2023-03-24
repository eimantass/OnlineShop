package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ServiceRepository;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
@Autowired
private ServiceRepository serviceRepsitory;
}
