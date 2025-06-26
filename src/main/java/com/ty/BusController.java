package com.ty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.dao.BusRepository;
import com.ty.dao.StopRepository;
import com.ty.dto.Bus;
import com.ty.dto.Stop;

@Controller
public class BusController {

    private final BusDemo1Application busDemo1Application;
	
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	StopRepository stopRepository;


    BusController(BusDemo1Application busDemo1Application) {
        this.busDemo1Application = busDemo1Application;
    }
	
	
	@GetMapping("/show")
	public String show() {
		return "show";
	}
	
	@GetMapping("/handles")
	public String loginbus() {
		
		return "login";
		
	}
	
	
	  @PostMapping("/login") 
	  public String addbus(@RequestParam String id,@RequestParam Integer password){
	  
	  if(id.equals("user")&&password==6949) { return "redirect:/addbus"; }
	  
	  return "redirect:/login"; }
	 
	
	
	
	@GetMapping("/addbus")
	public String addbus() {
		return "addbus";
	}
	
	
	@PostMapping("/admin/addbus")
	public String savebus(@ModelAttribute Bus bus) {
		for (Stop stop2 : bus.getStop()) {
			
			stop2.setBus(bus);
			
			
		}
		busRepository.save(bus);
		return "redirect:/show";
	}
	
	@GetMapping("/search")
	public String searchBuses(@RequestParam String stop1,
            @RequestParam String stop2,
            Model model) {
	
		   
		
			List<Bus> buses = busRepository.getbusbystopnameIgnoreCase(stop1, stop2);
		       model.addAttribute("buses", buses);
		       model.addAttribute("stop1", stop1);
		
   
	    return "searchResults"; // this is the name of the HTML/Thymeleaf page to show results
	}

	@RequestMapping("/showstop/{busid}")
	public String showstop(@PathVariable("busid") int id,Model model) {
		Bus bus=busRepository.getById(id);
		model.addAttribute(bus);
		return "showstop";
	}
	

}
