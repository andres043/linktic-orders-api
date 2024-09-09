package co.com.linktic.linkticordersapi.adapters.input.web;

import co.com.linktic.linkticordersapi.adapters.input.web.dto.Order;
import co.com.linktic.linkticordersapi.domain.usecases.ListOrdersUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Order", description = "API for managing orders")
public class ListOrdersController {

    private final ListOrdersUseCase listOrdersUseCase;

    @GetMapping("/orders")
    @Operation(summary = "List orders", description = "Returns a list of orders.")
    public ResponseEntity<List<Order>> listOrders() {
        List<Order> orders = listOrdersUseCase.listOrders()
                .stream().map(order -> new Order(order.orderId(), order.product(), order.quantity(), order.price()))
                .toList();

        return ResponseEntity.ok(orders);
    }
}
