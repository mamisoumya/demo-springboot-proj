package io.sample.springbootproj.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.sample.springbootproj.login.User;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.POST, value ="/order/create")
	public String createOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/order/details/edit")
	public String editOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/order/{id}/details/delete")
	public String deleteOrder(@PathVariable("id") String id ) {
		return orderService.deleteOrder(id);
	}
	
	@RequestMapping("/order/list")
	public List<Order> getOrdersList() {
		return orderService.getAllOrders();
	}
	
	@RequestMapping("/order/{id}/details")
	public Order getOrderDetails(@PathVariable("id") String id ) {
		return orderService.getOrder(id);
	}
	
	
}
