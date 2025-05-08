package lk.ac.vau.fas.ict.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MsgController {
	@GetMapping("/newmsg")
	public String myMessage() {
		return "Hello, this is an another Controller!!";
	}
}

