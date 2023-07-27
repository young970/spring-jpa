package com.kdt.clone.order.service;

import com.kdt.clone.domain.order.Order;
import com.kdt.clone.domain.order.OrderRepository;
import com.kdt.clone.domain.order.dto.OrderDto;
import com.kdt.clone.order.converter.OrderConverter;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderConverter orderConverter;
    private final OrderRepository orderRepository;

    public String save (OrderDto orderDto) {
        Order order = orderConverter.convertOrder(orderDto);
        Order save = orderRepository.save(order);
        return save.getUuid();
    }

    public String update(String uuid, OrderDto orderDto) throws NotFoundException {
        Order order = orderRepository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("주문을 찾을 수 없습니다."));

        order.setMemo(orderDto.getMemo());
        order.setOrderStatus(order.getOrderStatus());

        return order.getUuid();
    }

    public Page<OrderDto> findOrders(Pageable pageable) {
        return orderRepository.findAll(pageable)
                .map(orderConverter::convertOrderDto);
    }

    public OrderDto findOne (String uuid) throws NotFoundException {
        return orderRepository.findById(uuid)
                .map(orderConverter::convertOrderDto)
                .orElseThrow(() -> new NotFoundException("주문을 찾을 수 없습니다."));
    }
}
