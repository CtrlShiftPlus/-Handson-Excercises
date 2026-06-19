
class Product
{
    int productId;
    String productName;
    String category;

    public Product(int pid,String pname,String cat)
    {
        this.productId=pid;
        this.productName=pname;
        this.category=cat;
    }
    public String display()
    {
        return "Product ID:"+productId+"\nProduct Name:"+productName+"\nCategory:"+category;
    }
}

class Searching{
    public static Product linearSearch(Product[] products,int key)
    {
        for(Product product:products)
        {
            if(product.productId==key)
            {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products,int key)
    {
        int left=0;
        int right=products.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(products[mid].productId==key)
            {
                return products[mid];
            }
            else if(products[mid].productId<key)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return null;
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        Product[] products={
            new Product(100,"Soap","Provisions"),
            new Product(101, "Laptop", "Electronics"),
            new Product(102,"Detergent", "Cleaning"),
            new Product(103,"Potato Chips","Snacks"),
            new Product(104,"Table","Furniture")
        };
        Product res=Searching.linearSearch(products,103);
        if(res==null)
        {
            System.out.println("Product not found");
        }
        else
        {
            System.out.println("Linear Seach Result:"+res.display());
        }
        Product res2=Searching.binarySearch(products,103);
        if(res==null)
        {
            System.out.println("Product not found");
        }
        else
        {
            System.out.println("Binary Seach Result:"+res2.display());
        }
    }
}
