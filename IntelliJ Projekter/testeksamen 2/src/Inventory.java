import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> product;

    public Inventory()
    {
        product = new ArrayList<Product>();
    }

    public void addProduct(String name, double price )
    {
      product.add(new product(name, price));
    }

    public void printProduct()
    {
        System.out.println("Liste over produkter");
        for (Product p : product)

            System.out.println(p);
        }


    }

}
