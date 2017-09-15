package com.cg.core.pms.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.cg.core.pms.dto.Product;
import com.cg.core.pms.exception.ProductException;
import com.cg.core.pms.service.IProductService;
import com.cg.core.pms.service.ProductServiceImpl;
import com.cg.core.pms.util.ValidationUtil;
import com.sun.org.apache.regexp.internal.recompile;

interface MenuSelections
{
	int ADD_PRODUCT       = 1;
	int GET_PRODUCT       = 2;
	int UPDATE_PRODUCT    = 3;
	int REMOVE_PRODUCT    = 4;
	int VIEW_ALL_PRODUCTS = 5;
	int EXIT_APPLICATION  = 9;
}

public class PMSUI implements MenuSelections
{
	private IProductService productSerive;
	
	public PMSUI()
	{
		productSerive = new ProductServiceImpl();
	}
	public int displayMenu()
	{
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Select from options below:\n");
		System.out.println("1) Add Product Details");
		System.out.println("2) View Product Details");
		System.out.println("3) Update Product Details");
		System.out.println("4) Remove Product Details");
		System.out.println("5) View All Products");
		System.out.println("9) Exit Application");
		
		System.out.println("Enter your choice");
		choice = scan.nextInt();
		
		return choice;
	}
	
	public void processChoice()
	{
		int choice = displayMenu();
		
		switch(choice)
		{
		case ADD_PRODUCT      : addProduct();       break;
		case GET_PRODUCT      : getProduct();       break;
		case UPDATE_PRODUCT   : updateProduct();    break;
		case REMOVE_PRODUCT   : removeProduct();    break;
		case VIEW_ALL_PRODUCTS: viewAllProducts();  break;
		case EXIT_APPLICATION : 
			System.out.println("Good Bye");
			System.exit(0);
			break;
		default:
			System.out.println("\nEnter Valid Options Only\n");
			break;
		}
	}
	
	private void viewAllProducts()
	{
		try 
		{
			ArrayList<Product> products =
					productSerive.getAllProducts();
			
			Iterator<Product> it = products.iterator();
			System.out.println("ID\t Name\t Price\t Category\t Quantity");
			while(it.hasNext())
			{
				Product product = it.next();
				System.out.println(product.getId()+"\t"
						+product.getName()+"\t"
						+product.getPrice()+"\t"
						+product.getCategory()+"\t"
						+product.getQuantity());
			}
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong while retrieving all Products"+e.getMessage());
		}
		
	}
	private void removeProduct() 
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the id of product u want to remove: ");
		int id = console.nextInt();
		try {
			Product product = productSerive.removeProduct(id);
			System.out.println("Product Removed Successfully:");
			System.out.println("Details:");
			
			System.out.println("ID  :"+product.getId());
			System.out.println("Name:"+product.getName());
			System.out.println("Price : "+product.getPrice());
			System.out.println("Category:"+product.getQuantity());
			System.out.println("Quantity:"+product.getQuantity());
			
		}
		catch (Exception e) 
		{
			System.out.println("Something went wrong while removing Product"+e.getMessage());
		}
		
	}
	private void updateProduct() 
	{
		Scanner console = new Scanner(System.in);
		System.out.println("\nUpdate product details\n");
		System.out.println("\nEnter the Product ID\n");
		int id = console.nextInt();
		try {
			Product product = productSerive.getproduct(id);
			
			System.out.println("ID  :"+product.getId());
			System.out.println("Name:"+product.getName());
			System.out.println("Price : "+product.getPrice());
			System.out.println("Category:"+product.getQuantity());
			System.out.println("Quantity:"+product.getQuantity());
			System.out.println("\n\n");
			
			System.out.println("\nOld Name: "+product.getName());
			
			System.out.println("Do you want to update name: (yes/no)");
			String reply = console.next();
			
			if(reply !=null && reply.trim().equalsIgnoreCase("yes"))
			{
				System.out.println("Enter new name:");
				product.setName(console.next());
			}
			
			
			System.out.println("\nOld price: "+product.getPrice());
			
			System.out.println("Do you want to update price: (yes/no)");
			reply = console.next();
			
			if(reply !=null && reply.trim().equalsIgnoreCase("yes"))
			{
				System.out.println("Enter new price:");
				product.setPrice(console.nextFloat());
			}
			
			System.out.println("\nOld category: "+product.getCategory());
			
			System.out.println("Do you want to update category: (yes/no)");
			reply = console.next();
			
			if(reply !=null && reply.trim().equalsIgnoreCase("yes"))
			{
				System.out.println("Enter new category:");
				product.setCategory(console.next());
			}
			
			
			System.out.println("\nOld quantity: "+product.getQuantity());
			
			System.out.println("Do you want to update quantity: (yes/no)");
			reply = console.next();
			
			if(reply !=null && reply.trim().equalsIgnoreCase("yes"))
			{
				System.out.println("Enter new quantity:");
				product.setQuantity(console.nextInt());
			}
			
			productSerive.updateProduct(product);
			System.out.println("\nProduct Updated Successfully\n");
			
		} catch (ProductException e) {
			System.out.println("Something went wrong while updating  product"+" Reason: "+e.getMessage());
		}
		
		
		
	}
	private void getProduct() 
	{
		Scanner console = new Scanner(System.in);
		System.out.println("\nEnter the Product ID\n");
		int id = console.nextInt();
		try {
			Product product = productSerive.getproduct(id);
			System.out.println("ID  :"+product.getId());
			System.out.println("Name:"+product.getName());
			System.out.println("Price : "+product.getPrice());
			System.out.println("Category:"+product.getQuantity());
			System.out.println("Quantity:"+product.getQuantity());
			
			
		} catch (ProductException e) {
			System.out.println("Something went wrong while trying to retrieve a  product detail. Reason :: "+e.getMessage());
		}
		
	}
	private void addProduct()
	{
		Scanner console = new Scanner(System.in);
		
		System.out.println("\nInsert product Details\n");
		String  name;
		do
		{
		System.out.println("1) Product Name: ");
		name= console.next();
		}while(!ValidationUtil.isNameValid(name));
		
		System.out.println("2) Product Price");
		float price = console.nextFloat();
		
		System.out.println("3) Product category");
		String category = console.next();
		
		System.out.println("4) Product quantity");
		int quantity = console.nextInt();
		
		Product product = new Product(name,price,category,quantity);
		try 
		{
			int id = productSerive.addProduct(product);
			System.out.println("Product added successfully : ID "+id);
			
		} 
		catch (ProductException e) 
		{
			System.out.println("Something went wrong while adding a product. Reason :: "+e.getMessage());
			
		}
	}
	public static void main(String[] args)
	{
		PropertyConfigurator.configure("log4j.properties");
		PMSUI ui = new PMSUI();
		while(true)
		{
		ui.processChoice();
		}
		
	}

}
