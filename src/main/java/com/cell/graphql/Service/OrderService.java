package com.cell.graphql.Service;

import com.cell.graphql.entity.Order;
import com.cell.graphql.entity.User;
import com.cell.graphql.excepton.ExceptionHelper;
import com.cell.graphql.repository.OrderRepository;
import com.cell.graphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getAllOrder(){
        List<Order> orderList = orderRepository.findAll();
        return orderList;
    }
    public Order getOrderByOrderId(long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ExceptionHelper("resource not found with id" + orderId));
        return order;
    }
    public Order updateOrder(Order order) {

        Order ored = orderRepository.findById(order.getId())
                .orElseThrow(() ->
                        new ExceptionHelper("Resource not found with id " + order.getId()));

        if (ored != null) {

            ored.setOrderNumber(order.getOrderNumber());
            ored.setProductName(order.getProductName());

            ored.setQuantity(order.getQuantity());
            ored.setPrice(order.getPrice());
            ored.setUser(order.getUser());

            orderRepository.save(ored);

            return ored;

        } else {
            return null;
        }
    }

}
