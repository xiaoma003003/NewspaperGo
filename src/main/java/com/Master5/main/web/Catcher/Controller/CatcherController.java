package com.Master5.main.web.Catcher.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Master5.main.web.Catcher.entry.UrlsInfo;
import com.Master5.main.web.Catcher.service.CatcherService;

@Controller
@RequestMapping(value = "catcher")
public class CatcherController {
	@Autowired
	CatcherService catcherService;

	@RequestMapping(value = { "listUrlsInfo" })
	public String listUrlsInfo(Model model) {
		model.addAttribute("list", catcherService.queryUrlsInfo());
		return "catcher/listUrlsInfo";
	}

	@RequestMapping(value = "addUrlsInfo", method = RequestMethod.GET)
	public String addUrlsInfo() {
		return "catcher/addUrlsInfo";
	}

	@RequestMapping(value = "addUrlsInfo", method = RequestMethod.POST)
	public String addUrlsInfo(UrlsInfo urlsInfo) {
		catcherService.saveUrlsInfo(urlsInfo);
		return "redirect:listUrlsInfo";
	}

	@RequestMapping(value = "updateUrlsInfo/{id}", method = RequestMethod.GET)
	public String updateUrlsInfo(@PathVariable int id, Model model) {
		model.addAttribute("urlsInfo", catcherService.queryOne(id));
		return "catcher/updateUrlsInfo";
	}

	@RequestMapping(value = "updateUrlsInfo", method = RequestMethod.POST)
	public String updateUrlsInfo(UrlsInfo urlsInfo) {
		catcherService.saveUrlsInfo(urlsInfo);
		return "catcher/listUrlsInfo";
	}
	
	@RequestMapping(value = "work")
	public String updateUrlsInfo(String[] urls) {
		
		catcherService.catcher(urls);
		return "catcher/listUrlsInfo";
	}
	
}
