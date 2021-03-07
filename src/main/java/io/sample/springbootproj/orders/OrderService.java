package io.sample.springbootproj.orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public String addOrder(Order order) {

		try {
			orderRepository.save(order);
			return OrderResponse.SUCCESS.name();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return OrderResponse.FAILED.name();
		}
	}
	
	public Order getOrder(String id) {

		try {
			return orderRepository.findById(id).get();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Order> getAllOrders() {
		try {
			List<Order> orderList = new ArrayList<Order>();
			orderRepository.findAll().forEach(orderList::add);
			return orderList;
		} catch (Exception e) {
			return new ArrayList<Order>();
		}
	}

	public String deleteOrder(String id) {

		try {
			orderRepository.deleteById(id);
			return OrderResponse.SUCCESS.name();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return OrderResponse.FAILED.name();
		}
	}

}

enum OrderResponse {
	SUCCESS, FAILED
}
