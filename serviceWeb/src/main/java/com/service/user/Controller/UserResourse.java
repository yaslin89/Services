package com.service.user.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.user.dao.UserRepository;
import com.service.user.entitys.User;

@Controller
@RequestMapping
public class UserResourse {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/list")
	public String getUsers(Model model) {
		List<User> users = (List<User>) userRepository.findAll();
		model.addAttribute("users", users);
		return "index";
	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("user", new User());
		return "formNew";
	}

	@PostMapping("/save")
	public String save(@Valid User user, Model model) {
		Optional<User> optionalUser = userRepository.findById(user.getId());
		if (optionalUser.isPresent()) {
			User userupdate = user;
			userupdate.setName(user.getName());
			userupdate.setDateBirth(user.getDateBirth());
			userRepository.save(userupdate);
		} else {
			userRepository.save(user);
		}
		return "redirect:/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Optional<User> optionalUser = userRepository.findById(id);
		model.addAttribute("user", optionalUser);
		return "formEdit";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(Model model, @PathVariable("id") Long id) {
		userRepository.deleteById(id);
		return "redirect:/list";
	}

}
