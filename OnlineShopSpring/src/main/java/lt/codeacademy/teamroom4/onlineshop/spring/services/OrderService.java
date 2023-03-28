package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Order;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.OrderRepository;

@Service
public class OrderService {
	
	 private final OrderRepository orderRepository;
	 
	 @Autowired
	 public OrderService(OrderRepository orderRepository) {
		 this.orderRepository = orderRepository;
	 }
	 
	 public List<Order> getOrders(){
		 return orderRepository.findAll();
	 }
	 
	 public void addNewOrder(Order order) {
		 orderRepository.save(order);
	 }
	 
	 public void deleteOrder(Long orderId) {
		 orderRepository.deleteById(orderId);
	 }
}
