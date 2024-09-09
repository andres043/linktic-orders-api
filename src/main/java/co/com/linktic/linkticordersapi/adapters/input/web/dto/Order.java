package co.com.linktic.linkticordersapi.adapters.input.web.dto;


public record Order(String id, String product, int quantity, double price) {}