package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo pr;
	
	 public Product saveinfo(Product pp)
	 {
	    	return pr.save(pp);//saving the data from repository into the database
	 }
	    public List<Product> savedetails(List<Product> pp)
	    {
	    	return (List<Product>) pr.saveAll(pp);
	    }
	    public List<Product> showinfo()
	    {
	    	return pr.findAll();// retrieving the data that has been store in the database
	    }
	    public Optional<Product> showbyid(int id)
	    {
	    	return pr.findById(id);
	    }
	    public Product changeinfo(Product pp)
	    {
	    	return pr.saveAndFlush(pp);
	    }
	    public void deleteinfo(Product pp)
	    {
	    	pr.delete(pp);
	    }
	    
	    //delete by id for path variable
	    public void deleteid(int id)
	    {
	    	pr.deleteById(id);
	    }
	    
	    //delete by id for requestParam
	    public void deletepid(int id)
	    {
	    	pr.deleteById(id);
	    }
	    public String updateinfobyid(int id,Product pp)
	    {
	    	pr.saveAndFlush(pp);
	    	if(pr.existsById(id))
	    	{
	    		return "Updated";
	    	}
	    	else
	    	{
	    		return "Enter valid id";
	    	}
	    }
	    
		

}