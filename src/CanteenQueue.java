import helper.Queue;
import helper.impl.QueueLinkedListImpl;

public class CanteenQueue {
    static class Shop {
        private Queue<Customer> shop;

        public Shop() {
            this.shop = new QueueLinkedListImpl<>();
        }

        public void wait(Customer customer) {
            shop.enqueue(customer);
        }

        public void collectMoney() {
            while (!shop.isEmpty()) {
                Customer currentCustomer = shop.dequeue();
                collectMoney(currentCustomer);
            }
        }

        private void collectMoney(Customer customer) {
            StringBuilder builder = new StringBuilder();
            builder.append("Get money ").append(customer.payMoney())
                    .append(" by ").append(customer.getName())
                    .append(" pay for ");

            String[] products = customer.getProducts();
            builder.append("[");
            for (int i = 0; i < products.length; ++i) {
                if (i == products.length - 1)
                    builder.append(products[i]);
                else
                    builder.append(products[i]).append(", ");
            }
            builder.append("]").append("\n");

            // Print the result
            System.out.print(builder);
        }
    }

    static class Customer {
        private String name;
        private double money;
        private String[] products;

        public Customer(String name, double money, String[] products) {
            this.name = name;
            this.money = money;
            this.products = products;
        }

        public double payMoney() {
            return this.money;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setProducts(String[] products) {
            this.products = products;
        }

        public String[] getProducts() {
            return this.products;
        }
    }

    public static void main(String[] args) {
        // set up products for customer
        String[] anProducts = new String[] { "Coca Cola", "Beer", "Beef" };
        String[] hungProducts = new String[] { "Sprite", "Hamburger", "banana" };
        String[] binhProducts = new String[] { "Pepsi", "Peach", "Apple" };

        // Set up customer
        Customer MinAn = new Customer("An", 1_000_000, anProducts);
        Customer Hung = new Customer("Hung", 2_000_000, hungProducts);
        Customer Binh = new Customer("Binh", 1_000_000, binhProducts);

        // Set up shop
        Shop shop = new Shop();

        shop.wait(MinAn);
        shop.wait(Hung);
        shop.wait(Binh);

        shop.collectMoney();
    }
}
