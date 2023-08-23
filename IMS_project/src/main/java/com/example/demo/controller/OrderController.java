package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

	@Autowired
   OrderService oser;
	
	@PostMapping("addorder")
	public Order add(@RequestBody Order oo)
	{
		return oser.saveinfo(oo);
	}

	@PostMapping("addnorders")
	public List<Order> addndetails(@RequestBody List<Order> oo)
	{
		return oser.savedetails(oo);
	}
	
    
	@GetMapping("showorders")
   public List<Order> show()
   {
	   return oser.showinfo();
   }
	@GetMapping("showordbyid/{id}")
	 public Optional<Order> showid(@PathVariable int id)
	 {
		   return oser.showbyid(id);
	 }
	
	@PutMapping("updateorders")
	public Order modify(@RequestBody Order oo)
	{
		return oser.changeinfo(oo);
	}

	@PutMapping("oupdatebyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody Order oo)
	{
		return oser.updateinfobyid(id, oo);
	}
	
	@DeleteMapping("deleteorder")
	public String del(@RequestBody Order oo )
	{
		oser.deleteinfo(oo);
		return "Deleted succesfully";
	}
	@DeleteMapping("odelid/{id}")
	public void deletemyid(@PathVariable int id)
	{
		oser.deleteid(id);
		
	}
	@DeleteMapping("odelparamid")
	public void deletemyparamid(@RequestParam int id)
	{
		oser.deletepid(id);
		
	}
	
}