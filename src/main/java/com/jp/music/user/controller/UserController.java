package com.jp.music.user.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.music.common.controller.BaseController;
import com.jp.music.user.model.User;
import com.jp.music.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getUserCreateForm(Map<String, Object> map) {
		map.put("user", new User());
		map.put("userList", userService.findAllUsers());

		return "user/user";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result) {

		if(result.hasErrors()) {
			return "/user/user";
		}

		if(user != null) {
			userService.saveUser(user);
		}

		return "redirect:/user/";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);

		return "redirect:/user/";
	}
}
