package presenter;

import java.util.ArrayList;
import java.util.List;

import model.ETypeProduct;

import model.Product;

import model.ServiceSale;

public class Presenter {
    private List<ServiceSale> sales;
    private double totalSalesAmount;
    private int totalSalesCount;

    public Presenter() {
        sales = new ArrayList<>();
        totalSalesAmount = 0;
        totalSalesCount = 0;
    }

    public double addSale(String name, double value, int stock, boolean iva, ETypeProduct typeProduct, int cant) {
        Product product = new Product(name, value, stock, iva, typeProduct);
        ServiceSale serviceSale = new ServiceSale(product, cant);
        sales.add(serviceSale);

        
        

        

        return serviceSale.getSale().getTotalSale();
    }

    public String showSale() {
        StringBuilder result = new StringBuilder();

        for (ServiceSale serviceSale : sales) {
        	 result.append(serviceSale.getSale().getProduct().getName())
             .append(": ")
             .append(serviceSale.getSale().getCant())
             .append(" x ")
             .append(serviceSale.getSale().getProduct().getValue())
             .append(" = ")
             .append(serviceSale.getSale().getTotalSale())
             .append(", Descuento: ")
             .append(serviceSale.getSale().calcDiscount())
             .append(", IVA: ")
             .append(serviceSale.getSale().calcIva())
             .append("\n");
     totalSalesAmount += serviceSale.getSale().getTotalSale();        }

        result.append("Total de ventas: ").append(totalSalesAmount).append("\n");
        double average = sales.isEmpty() ? 0 : totalSalesAmount / sales.size();
        result.append("Promedio de ventas: ").append(average).append("\n");
        return result.toString();
    }
}





