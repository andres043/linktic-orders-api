package co.com.linktic.linkticordersapi.domain.models;

public record Order(String orderId ,String product, int quantity, double price) {}
