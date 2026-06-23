
public class App {

    static class Pizza {
        private String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;

        private Pizza(Builder builder) {
            this.size = builder.size;
            this.cheese = builder.cheese;
            this.pepperoni = builder.pepperoni;
            this.mushrooms = builder.mushrooms;
        }

        public void show() {
            System.out.println("Pizza Size: " + size);
            System.out.println("Cheese: " + cheese);
            System.out.println("Pepperoni: " + pepperoni);
            System.out.println("Mushrooms: " + mushrooms);
        }

        static class Builder {
            private String size;
            private boolean cheese;
            private boolean pepperoni;
            private boolean mushrooms;

            public Builder setSize(String size) {
                this.size = size;
                return this;
            }

            public Builder addCheese(boolean cheese) {
                this.cheese = cheese;
                return this;
            }

            public Builder addPepperoni(boolean pepperoni) {
                this.pepperoni = pepperoni;
                return this;
            }

            public Builder addMushrooms(boolean mushrooms) {
                this.mushrooms = mushrooms;
                return this;
            }

            public Pizza build() {
                return new Pizza(this);
            }
        }
    }

    public static void main(String[] args) {
        Pizza p1 = new Pizza.Builder()
                .setSize("Large")
                .addCheese(true)
                .addPepperoni(true)
                .addMushrooms(false)
                .build();

        Pizza p2 = new Pizza.Builder()
                .setSize("Medium")
                .addCheese(true)
                .addPepperoni(false)
                .addMushrooms(true)
                .build();

        p1.show();
        System.out.println();
        p2.show();
    }
}