package co.com.linktic.linkticordersapi.configuration;

import co.com.linktic.linkticordersapi.adapters.output.dynamo.OrderRepository;
import co.com.linktic.linkticordersapi.domain.ports.ListOrdersPort;
import co.com.linktic.linkticordersapi.domain.usecases.ListOrdersUseCase;
import co.com.linktic.linkticordersapi.domain.usecases.impl.ListOrdersUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.identity.spi.IdentityProperty;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class Initializer {

    @Bean
    public ListOrdersUseCase listOrdersUseCaseImpl(OrderRepository orderRepository) {
        return new ListOrdersUseCaseImpl(orderRepository);
    }

    @Bean
    public DynamoDbClient dynamoDbClient() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create("accessKeyId", "secretAccessKey");
        Region region = Region.US_EAST_1;
        return DynamoDbClient.builder()
                .region(region)
                .endpointOverride(URI.create("http://localhost:4566"))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }
}
