package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Order;
import com.order.model.ProductDto;
import com.order.model.UserDto;
import com.order.service.OrderServiceImpl;
import com.order.service.ProductService;
import com.order.service.UserService;



@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String homepage() {
		return  "this is order home page";
	}
	
	@PostMapping("/order/product")
	public ResponseEntity<Order> orderProduct (
			@RequestBody Order order,
			@RequestParam Long productId,
			@RequestParam int quantity,
			@RequestHeader ("Authorization") String jwt
			)throws Exception
	{
			UserDto user=userService.getUserProfile(jwt);
			ProductDto product=productService.getProductByProductId(productId);
			Order neworder=orderServiceImpl.orderProduct(order,product.getProductId(),user.getId(), quantity);
			return new ResponseEntity<>(neworder, HttpStatus.CREATED);
	}
	
	@GetMapping("all/orders")
	private ResponseEntity<List<Order>> getallOrders(@RequestHeader("Authorization") String jwt)throws Exception{
		UserDto user=userService.getUserProfile(jwt);
		List<Order> orders = orderServiceImpl.getallOrders(user.getRole());
        return ResponseEntity.ok(orders);
	}

	@GetMapping("order/{orderId}")
    public ResponseEntity<?> getOrderByOrderId(@PathVariable Long orderId) {
        try {
            Order order = orderServiceImpl.getOrderByOrderId(orderId);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("order now available");
        }
    }

}
