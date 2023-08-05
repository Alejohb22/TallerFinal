package model;

public class ServiceSale {
	private Sale sale;
	
	public ServiceSale(Product product, int cant) {
        sale = new Sale(product, cant);
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Sale getSale() {
        return sale;
    }
	
	
	
	
	
	
	
	

}
