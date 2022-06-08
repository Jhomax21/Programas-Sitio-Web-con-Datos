package pe.edu.upc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerVista {

	@GetMapping("/")
	public String red() {

		return "login";
	}
}
