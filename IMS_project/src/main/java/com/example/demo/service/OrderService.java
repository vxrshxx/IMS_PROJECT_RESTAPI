package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepo;


@Service
public class OrderService {

	@Autowired
	
	OrderRepo or;
	
	 public Order saveinfo(Order oo)
	 {
	    	return or.save(oo);//saving the data from repository into the database
	 }
	    public List<Order> savedetails(List<Order> oo)
	    {
	    	return (List<Order>) or.saveAll(oo);
	    }
	    public List<Order> showinfo()
	    {
	    	return or.findAll();// retrieving the data that has been store in the database
	    }
	    public Optional<Order> showbyid(int id)
	    {
	    	return or.findById(id);
	    }
	    public Order changeinfo(Order oo)
	    {
	    	return or.saveAndFlush(oo);
	    }
	    public void deleteinfo(Order oo)
	    {
	    	or.delete(oo);
	    }
	    
	    //delete by id for path variable
	    public void deleteid(int id)
	    {
	    	or.deleteById(id);
	    }
	    
	    //delete by id for requestParam
	    public void deletepid(int id)
	    {
	    	or.deleteById(id);
	    }
	    public String updateinfobyid(int id,Order oo)
	    {
	    	or.saveAndFlush(oo);
	    	if(or.existsById(id))
	    	{
	    		return "Updated";
	    	}
	    	else
	    	{
	    		return "Enter valid id";
	    	}
	    }
	    
}
