package com.order.service;



import java.util.List;

import com.order.model.Order;

public interface OrderService {
	
	Order orderProduct(Order order,Long productId, Long userId,int quantity)throws Exception;
	
	List<Order> getallOrders(String requestRole)throws Exception;
	
	Order getOrderByOrderId(Long orderId)throws Exception;
	
	

}
