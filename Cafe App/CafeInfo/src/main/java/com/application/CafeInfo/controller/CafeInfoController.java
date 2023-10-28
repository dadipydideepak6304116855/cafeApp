package com.application.CafeInfo.controller;

import java.util.List;
import java.util.Optional;

import com.application.CafeInfo.entity.CafeInfo;
import com.application.CafeInfo.service.CafeInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CafeInfoController {
	
	
	@Autowired
	public  CafeInfoService cafeInfoService;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/addCafe")
	public String addCafe(@ModelAttribute("cafeName") String cafeName,@ModelAttribute("cafeDesc")String cafeDesc) {
		System.out.println("Inside the controller addCafe post method");
		CafeInfo cafeInfo=new CafeInfo(cafeName,cafeDesc);
		System.out.println("details of cafeInfo is:"+cafeInfo.getCafeName()+" "+cafeInfo.getCafeDesc());
		
		CafeInfo savedCafeInfo=cafeInfoService.addCafe(cafeInfo); //control goes to the service class-addCafe method
		if (savedCafeInfo!=null)
		{
			return "success"; //templates/success.html
		}
		else
		{
			return "fail"; //templates/fail.html
		}
	}
	
	@GetMapping("/getCafes")
	@ResponseBody
	public List<CafeInfo> getCafes(){
		return cafeInfoService.getCafes();  //returns data
	}
	
	
	@GetMapping("/getCafe/{cafeId}")
	@ResponseBody
	public Optional<CafeInfo> getCafe(@PathVariable("cafeId") Integer cafeId){
		return cafeInfoService.getCafe(cafeId);
	}
	
	@GetMapping("/count")
	@ResponseBody
	public String getCafeCount() {
		return String.valueOf(cafeInfoService.getCafes().size());
	}
	
	@GetMapping("/getAll/{cafeId}")
	public ModelAndView getAll(@PathVariable("cafeId")Integer cafeId) {
		return cafeInfoService.getAll(cafeId);
	}

}
