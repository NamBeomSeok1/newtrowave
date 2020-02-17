package com.kostars.newtroshop.web;


import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.order.Ordered;
import com.kostars.newtroshop.service.OrderService;
import com.kostars.newtroshop.web.dto.request.OrderItemsRequestDto;
import com.kostars.newtroshop.web.dto.request.OrderedApiRequestDto;
import com.kostars.newtroshop.web.dto.response.OrderedApiResponseDto;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;

@RestController
@RequestMapping("/api/order")
public class OrderApiController implements CrudInterface<OrderedApiRequestDto, OrderedApiResponseDto> {

    @Autowired
    private OrderService orderService;

    @Override
    @PostMapping(value = "", consumes = "application/json;charset=UTF-8")
    public Header<OrderedApiResponseDto> create(@RequestBody Header<OrderedApiRequestDto> request) {
        return orderService.create(request);
    }

    @Override
    @GetMapping(value = "{id}")
    public Header<OrderedApiResponseDto> read(@PathVariable Long id) {


        return orderService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<OrderedApiResponseDto> update(@RequestBody Header<OrderedApiRequestDto> request) {
        return orderService.update(request);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public Header delete(@PathVariable Long id) {
        return orderService.delete(id);
    }


    @PostMapping(value = "/orderitem", consumes = "application/json;charset=UTF-8")
    public Header createOrderItem(@RequestBody Header<OrderItemsRequestDto> request) throws Exception {
        return orderService.createOrderItem(request);
    }


    @GetMapping(value = "/orderitem/{id}")
    public Header readOrderItem(@PathVariable Long id) {
        return orderService.readOrderItem(id);
    }

    @DeleteMapping(value = "/orderitem/{id}")
    public Header delOrderItem(@PathVariable Long id){
        return orderService.deleteOrderItem(id);
    }

}
