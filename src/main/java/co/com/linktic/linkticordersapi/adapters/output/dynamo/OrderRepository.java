package co.com.linktic.linkticordersapi.adapters.output.dynamo;

import co.com.linktic.linkticordersapi.domain.models.Order;
import co.com.linktic.linkticordersapi.domain.ports.ListOrdersPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OrderRepository implements ListOrdersPort {

    private final DynamoDbClient dynamoDbClient;

    @Override
    public List<Order> listOrders() {
        ScanResponse scanResponse = dynamoDbClient.scan(ScanRequest.builder().tableName("orders").build());
        return scanResponse.items().stream()
                .map(item -> new Order(
                        item.get("order_id").s(),
                        item.get("product").s(),
                        Integer.parseInt(item.get("quantity").n()),
                        Integer.parseInt(item.get("price").n())))
                .toList();
    }
}
