package pro.vinyard.project.rest.controller;

import org.springframework.web.bind.annotation.*;
import pro.vinyard.project.rest.data.User;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
public class UserController {
	
	@RequestMapping("/login")
	public boolean login(@RequestBody User user) {
		return user.getUserName().equals("admin") && user.getPassword().equals("admin");
	}
	
	@RequestMapping("/user")
	public Principal user(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization")
				.substring("Basic".length()).trim();
		return () ->  new String(Base64.getDecoder()
				.decode(authToken)).split(":")[0];
	}
}