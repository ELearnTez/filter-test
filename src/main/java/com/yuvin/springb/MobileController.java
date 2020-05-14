package com.yuvin.springb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yuvin.springb.model.Lob;
import com.yuvin.springb.model.Mobiles;
import com.yuvin.springb.model.Status;

@RestController
public class MobileController {
	
	@Autowired
	private MobileRepository repository;

	@PostMapping("save")
	@ResponseStatus(value= HttpStatus.CREATED)
	public Mobiles save(@RequestBody Mobiles mobile) {
		//mobile.setPublicationDate(LocalDate.now());
		repository.saveAndFlush(mobile);
		return mobile;
	}
	
	@GetMapping("mobile/id")
	public Mobiles getMobileById(@PathVariable int id) {
		return repository.findById(id).get();
	}
	
	@GetMapping("mobiles")
	public List<Mobiles> findAll(MobileRequest request){
		System.out.println(request);
		
		Status status  = 
				!StringUtils.isEmpty(request.getStatus()) ? 
						Status.valueOf(request.getStatus()) :
							null;
		 Lob lob = !StringUtils.isEmpty(request.getLob()) ? 
					Lob.valueOf(request.getLob()) :
						null;
						
						
	   return repository.getAllResults(request.getName(),request.getPrice(), status, lob);						
	}
	
	@GetMapping("hi")
	public String sayHello() {
		return "Hi My Dear Spring Boot.!";
				
	}
	
	
}
