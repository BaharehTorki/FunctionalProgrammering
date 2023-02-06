package org.example.gui;

import org.example.model.Basket;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.User;
import org.example.service.*;

import java.time.LocalDate;
import java.util.*;

import static org.example.gui.StringsConstant.PRODUCT_HEADER;

public class MyPage {
    private final Dao dao = new DaoImpl();
    private final User user;
    private List<Basket> allOrderByUser;
    private static final Scanner IN = new Scanner(System.in);

    public MyPage(String username) {
        this.user = dao.findUserByUsername(username);

        this.allOrderByUser = getAllOrderByUser(user);

        System.out.println(
                StringsConstant.EMPTYLINE +
                        String.format(StringsConstant.MYPAGE, user.getName(), user.getEfternamn(), LocalDate.now(), allOrderByUser.size(), allOrderByUser.stream().map(Basket::getOrderID).toList()));
        menu();
    }

    private void menu() {
        while (true) {
            System.out.println(StringsConstant.MENU);
            char s = IN.next().charAt(0);
            switch (s) {
                case 'a' -> print(() -> new PrintForm<>(PRODUCT_HEADER, dao.getAllProduct()));
                case 'b' -> makeAOrder();
                case 'f' -> filterMenu();
                case 'x' -> System.exit(0);
            }
        }
    }

    private void filterMenu() {
        boolean loop= true;
        while (loop) {
            System.out.println(StringsConstant.FILTER_MENU);
            char c = IN.next().charAt(0);
            switch (c){

                case 'k' -> {
                    System.out.println("Vilken kategory?");
                    String  size = IN.next();
                    filterProduct(size,(p, s) -> s.equalsIgnoreCase(p.getCategoryType().name()));
                }
                case 's' -> {
                    System.out.println("Vilket storlek?");
                    String  size = IN.next();
                    filterProduct(size,(p, s) -> Integer.parseInt(s)==p.getStorlek());
                }
                case 'm' -> {
                    System.out.println("Vilken märke?");
                    String  size = IN.next();
                    filterProduct(size,(p, s) -> s.equalsIgnoreCase(p.getMarke()));
                }
                case 'f' -> {
                    System.out.println("Vilken färg?");
                    String  size = IN.next();
                    filterProduct(size,(p, s) -> s.equalsIgnoreCase(p.getColor()));
                }
                case 'a' -> {
                    System.out.println("Vilken avdelning?");
                    String  size = IN.next();
                    filterProduct(size,(p, s) -> s.equalsIgnoreCase(p.getSectionType().name()));
                }
                case 'b' -> {
                    makeAOrder();
                    loop= false;
                }
            }
        }
    }
    private List<Product> filterProduct(String searchAttribute, ProductSearcherInterface psi){

        List<Product> products = dao.getAllProduct().stream()
                .filter(p -> psi.search(p, searchAttribute))
                .toList();
        print(() -> new PrintForm<>(PRODUCT_HEADER, products));

        return products;
    }

    private boolean makeAOrder() {

        System.out.println("Du har redan detta beställning nummer: "+ allOrderByUser.stream().map(Basket::getOrderID).toList());

        System.out.println("Ange beställningsnummer och artikelnummer: ");

        String orderId = IN.next();
        int productId = IN.nextInt();
        boolean b = dao.addToCart(user.getId(), orderId, productId);
        if (b) {
            System.out.printf("Produkt med id= %d är adderat i beställning id=%s\n", productId, orderId);
            return true;
        } else {
            System.out.printf("Produkt med id= %d är saknas\n",productId);
            return false;
        }
    }

    private List<Basket> getAllOrderByUser(User user) {
        List<Order> allOrderByUserId = dao.getAllOrderByUserId(user.getId());
        List<Basket> basketList = new ArrayList<>();

        for (Order o : allOrderByUserId) {
            Basket basket = findAnyBasket(o.getOrderId(), basketList);
            if (basket != null) {
                basket.getProducts().add(o.getProduct());
            } else {
                basketList.add(new Basket(user, o.getOrderId(), o.getProduct()));
            }
        }
        return basketList;
    }

    private Basket findAnyBasket(String orderId, List<Basket> basketList) {
        for (Basket b : basketList) {
            if (b.getOrderID().equalsIgnoreCase(orderId)) {
                return b;
            }
        }
        return null;
    }

    private void print(PrintInterface<?> printInterface) {
        printInterface.getPrintForm().print();

    }

}
