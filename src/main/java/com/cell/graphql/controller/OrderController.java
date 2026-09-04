package com.cell.graphql.controller;

import com.cell.graphql.Service.OrderService;
import com.cell.graphql.Service.UserService;
import com.cell.graphql.entity.Order;
import com.cell.graphql.entity.User;
import com.cell.graphql.payload.UserCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;


    @MutationMapping
    public Order createOrder(@Argument String orderNumber,
                            @Argument String productName,
                            @Argument Integer quantity,
                            @Argument Float price,
                            @Argument int user){
      Order order=new Order();
      order.setOrderNumber(orderNumber);
      order.setPrice(Double.valueOf(price));
      order.setProductName(productName);
      order.setQuantity(quantity);

        User userByUserId = userService.getUserByUserId(user);
        order.setUser(userByUserId);


        return orderService.addOrder(order);
    }

    @QueryMapping(name = "getAllOrders")
    public List<Order> getAllOrder(){
        List<Order> allOrder = orderService.getAllOrder();
        return allOrder;
    }

    @QueryMapping
    public Order getOrder(@Argument int orderId){
        Order order = orderService.getOrderByOrderId(orderId);
        return order;
    }

}
