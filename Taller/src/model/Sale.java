package model;
import model.ServiceSale;

public class Sale {
	
	private Product product;
	
	private int cant;
	
	
	


	
	public Sale(Product product, int cant) {
		super();
		this.product = product;
		this.cant = cant;
	}
	
	

	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public int getCant() {
		return cant;
	}



	public void setCant(int cant) {
		this.cant = cant;
	}



	public int calcDiscount() {
		int cant = getCant();
        int discount = 0;		
        
        if(cant>=5 && cant<=10) {
        	discount = 5;
        }else if(cant>=11 && cant<=20) {
        	discount = 10;
        	
        }else if(cant>=21 && cant<=50) {
        	
        	discount = 20;
        }else if(cant>50) {
        	discount = 30;
        }
        
        return cant*discount/100;
        
        
			
		}
	
	
	public double getTotalSale() {
		int cant = getCant();
	    double unitValue = getProduct().getValue();

	    
	    double totalSale = cant * unitValue;

	    int discount = calcDiscount();
	    double discountAmount = totalSale * discount / 100;

	    
	    totalSale -= discountAmount;
	    
	    if (getProduct().isIva()) {
	        double ivaAmount = totalSale * 0.16;
	        totalSale += ivaAmount;}

	    return totalSale;
		
	
	}
	
	public double calcIva() {
		 return product.isIva() ? getTotalSale() * 0.16 : 0.0;	}
	
	
	

}
