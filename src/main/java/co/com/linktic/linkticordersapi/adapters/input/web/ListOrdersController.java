package co.com.linktic.linkticordersapi.adapters.input.web;

import co.com.linktic.linkticordersapi.adapters.input.web.dto.Order;
import co.com.linktic.linkticordersapi.domain.usecases.ListOrdersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ListOrdersController {

    private final ListOrdersUseCase listOrdersUseCase;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> listOrders() {
        List<Order> orders = listOrdersUseCase.listOrders()
                .stream().map(order -> new Order(order.orderId(), order.product(), order.quantity(), order.price()))
                .toList();

        return ResponseEntity.ok(orders);
    }
}
