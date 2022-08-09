package com.codingdojo.ninjaGoldGame.controllers;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {
	
	@RequestMapping("/Gold")
	public String gold(HttpSession session, Model model) {
		Integer gold = (Integer) session.getAttribute("gold");
		String messages = (String) session.getAttribute("messages"); 				
		int totalGold = (gold == null) ? totalGold = 0 : gold;
		model.addAttribute("totalGold", totalGold);
		model.addAttribute("messages", messages);
		return "gold.jsp";
	}
	
	@RequestMapping(value="/formProcess", method=RequestMethod.POST)
	public String formProcess(@RequestParam(value="mission") String mission, HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		String newMessage;
		String messages = (String) session.getAttribute("messages"); 
		if (messages == null) {
			messages = "";
		}
		gold = (gold == null) ? gold = 0 : gold;
		Random randomGold = new Random();
		int addGold;
		if (mission.equals("farm"))
		{
			addGold = randomGold.nextInt((20-10) + 1) + 10;
			newMessage = "You entered a farm and earned " + addGold + " gold.," + messages;
			addGold += gold;
			session.setAttribute("gold", addGold);
			session.setAttribute("messages", newMessage);
		}
		else if (mission.equals("cave"))
		{
			addGold = randomGold.nextInt((10-5) + 1) + 5;
			newMessage ="You entered a cave and earned " + addGold + " gold.," + messages;
			addGold += gold;
			session.setAttribute("gold", addGold);
			session.setAttribute("messages", newMessage);
		}
		else if (mission.equals("house"))
		{
			addGold = randomGold.nextInt((5-2) + 1) + 2;
			newMessage ="You entered a house and earned " + addGold + " gold.," + messages;
			addGold += gold;
			session.setAttribute("gold", addGold);
			session.setAttribute("messages", newMessage);
		}
		else if (mission.equals("quest"))
		{
			int addOrRemove = randomGold.nextInt(2) + 1;
			if (addOrRemove == 1) {
				addGold = (randomGold.nextInt(50) * -1);
				newMessage = "You failed a quest and lost " + addGold + " gold. Ouch.," + messages;
				addGold += gold;
				session.setAttribute("gold", addGold);
				session.setAttribute("messages", newMessage);
			} else {
				addGold = (randomGold.nextInt(50));
				newMessage = "You completed a quest and won " + addGold + " gold. Yay!," + messages;
				addGold += gold;
				session.setAttribute("gold", addGold);
				session.setAttribute("messages", newMessage);
			}

		}
		return "redirect:/Gold";
	}

}
