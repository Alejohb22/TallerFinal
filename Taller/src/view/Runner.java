package view;
import presenter.Presenter;
import model.ETypeProduct;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Presenter presenter = new Presenter();
		
		while(true) {
			System.out.println("Ingrese una opción:");
			System.out.println("1.Agregar venta");
			System.out.println("2.Mostrar ventas");
			System.out.println("0.Salir");
			int option= scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {
			case 1:
				System.out.println("Ingrese el nombre del producto:");
				String name= scanner.nextLine();
				
				System.out.println("Ingrese el valor del producto:");
				double value = scanner.nextDouble();
				
				System.out.println("Ingrese el stock del producto:");
				int stock = scanner.nextInt();
				
				System.out.println("¿El producto tiene IVA? (true/false):");
				boolean iva = scanner.nextBoolean();
				
				System.out.println("Ingrese el tipo del producto (LICORES, VIVERES, MEDICINAS, ASEO, RANCHO");
				String typeProductStr = scanner.next();
				ETypeProduct typeProduct = ETypeProduct.valueOf(typeProductStr);
				
				System.out.println("Ingrese la cantidad vendida:");
				int cant = scanner.nextInt();
				
				double totalSale = presenter.addSale(name, value, stock, iva, typeProduct, cant);
			    System.out.println("Venta agregada. Total de la venta: " + totalSale);
			    
			    
				
				break;
				
			case 2:
				System.out.println("Ventas realizadas:");
				System.out.println(presenter.showSale());
				break;
			
			case 0:
				System.out.println("Saliendo...");
				return;
				
				default:
					System.out.println("Opcion invalida. Ingrese una nueva opcion valida");
			}
			
		}
	}

}
