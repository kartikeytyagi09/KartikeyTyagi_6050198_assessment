package com.abes.client;

import java.util.*;
import com.abes.dao.*;
import com.abes.entity.*;

public class DaoClient {

    static OrderDao dao = new OrderDaoImpl();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String opt = null;

        do {

            System.out.println("1-ADD, 2--VIEW BY ORDER ID, 3--VIEW BY CUSTOMER NAME");

            int mtype = scan.nextInt();

            processMenu(mtype);

            System.out.println("press y to continue");

            opt = scan.next();

        } while (opt.equalsIgnoreCase("y"));

    }

    public static void processMenu(int mtype) {

        switch (mtype) {

            case 1:
                addOrder();
                break;

            case 2:
                viewOrderByOrderID();
                break;

            case 3:
                viewOrdersByCustName();
                break;

            default:
                System.out.println("Invalid option");
        }

    }

    public static void addOrder() {

        System.out.println("Enter Customer ID:");
        int cid = scan.nextInt();

        System.out.println("Enter Order Amount:");
        double amt = scan.nextDouble();

        Customer c = new Customer();
        c.setCustomerId(cid);

        Order order = new Order(new Date(), amt, c);

        dao.addOrder(order);

        System.out.println("Order Added");

    }

    public static void viewOrderByOrderID() {

        System.out.println("Enter Order ID:");

        int id = scan.nextInt();

        Order order = dao.viewOrderById(id);

        System.out.println(order);

    }

    public static void viewOrdersByCustName() {

        System.out.println("Enter Customer Name:");

        String name = scan.next();

        List<Order> orders = dao.viewOrdersByCustomerName(name);

        orders.forEach(System.out::println);

    }

}