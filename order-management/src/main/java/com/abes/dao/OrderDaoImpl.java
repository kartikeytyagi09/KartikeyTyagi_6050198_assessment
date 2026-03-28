	package com.abes.dao;
	
	import jakarta.persistence.*;
	import java.util.List;
	import com.abes.entity.*;
	
	public class OrderDaoImpl implements OrderDao {
	
	    EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("JPA-PU");
	
	    @Override
	    public void addOrder(Order order) {
	
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction tx = em.getTransaction();
	
	        tx.begin();
	
	        // fetch existing customer from DB
	        Customer cust = em.find(Customer.class,
	                                order.getCustomer().getCustomerId());
	
	        order.setCustomer(cust);
	
	        em.persist(order);
	
	        tx.commit();
	        em.close();
	    }
	
	    @Override
	    public Order viewOrderById(int id) {
	
	        EntityManager em = emf.createEntityManager();
	
	        Order order = em.find(Order.class, id);
	
	        em.close();
	
	        return order;
	    }
	
	    @Override
	    public List<Order> viewOrdersByCustomerName(String name) {
	
	        EntityManager em = emf.createEntityManager();
	
	        TypedQuery<Order> query =
	                em.createQuery(
	                        "select o from Order o where o.customer.customerName=:name",
	                        Order.class);
	
	        query.setParameter("name", name);
	
	        return query.getResultList();
	    }
	}