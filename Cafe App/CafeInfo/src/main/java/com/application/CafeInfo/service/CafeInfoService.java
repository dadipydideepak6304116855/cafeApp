package com.application.CafeInfo.service;

import java.util.List;
import java.util.Optional;

import com.application.CafeInfo.entity.CafeInfo;
import com.application.CafeInfo.entity.CafeReview;
import com.application.CafeInfo.repository.CafeInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Service
public class CafeInfoService {
	
	@Autowired
	CafeInfoRepository cafeInfoRepository;
	
	@Autowired
	RestTemplate restTemplate;

	 public CafeInfo addCafe(CafeInfo cafeInfo) {
	       return cafeInfoRepository.save(cafeInfo);
	      
	    }

	public List<CafeInfo> getCafes() {
		return cafeInfoRepository.findAll();
	}

	public Optional<CafeInfo> getCafe(Integer cafeId) {
		
		return cafeInfoRepository.findById(cafeId);
	}
    
	@SuppressWarnings("unchecked")
	public ModelAndView getAll(Integer cafeId)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("cafeInfo",this.getCafe(cafeId).get());
		
		final String uri = "http://localhost:8090/getReview/"+""+cafeId;

	    RestTemplate restTemplate = new RestTemplate();
	    List<CafeReview> result = restTemplate.getForObject(uri, List.class);
	    System.out.println("details of results:"+result.toString()); 
	    mv.addObject("cafeReview",result);
		mv.setViewName("cafeAll");
		return mv;
	}


}
