package com.florian935.cloud.kafka.producer.controller;

import com.florian935.cloud.kafka.producer.producer.ProductProducer;
import com.florian935.cloud.kafka.producer.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1.0/products")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ProductController {

    ProductProducer productProducer;

    @PostMapping(path = "/{action}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(ACCEPTED)
    Product produce(@PathVariable String action, @RequestBody Product product) {

        productProducer.send(product, action);

        return product;
    }

}
