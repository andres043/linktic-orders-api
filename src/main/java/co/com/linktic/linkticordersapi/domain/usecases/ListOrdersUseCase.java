package co.com.linktic.linkticordersapi.domain.usecases;

import co.com.linktic.linkticordersapi.domain.models.Order;

import java.util.List;

public interface ListOrdersUseCase {

    List<Order> listOrders();
}
