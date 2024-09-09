package co.com.linktic.linkticordersapi.domain.usecases.impl;

import co.com.linktic.linkticordersapi.domain.models.Order;
import co.com.linktic.linkticordersapi.domain.ports.ListOrdersPort;
import co.com.linktic.linkticordersapi.domain.usecases.ListOrdersUseCase;

import java.util.List;

public class ListOrdersUseCaseImpl implements ListOrdersUseCase {

    private final ListOrdersPort listOrdersPort;

    public ListOrdersUseCaseImpl(ListOrdersPort listOrdersPort) {
        this.listOrdersPort = listOrdersPort;
    }

    @Override
    public List<Order> listOrders() {
        return listOrdersPort.listOrders();
    }
}
