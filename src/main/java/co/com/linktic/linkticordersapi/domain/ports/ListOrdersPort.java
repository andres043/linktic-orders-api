package co.com.linktic.linkticordersapi.domain.ports;

import co.com.linktic.linkticordersapi.domain.models.Order;

import java.util.List;

public interface ListOrdersPort {

    List<Order> listOrders();
}
