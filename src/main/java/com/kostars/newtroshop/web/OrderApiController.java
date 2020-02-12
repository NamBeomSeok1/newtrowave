package com.kostars.newtroshop.web;


import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.domain.order.Ordered;
import com.kostars.newtroshop.service.OrderService;
import com.kostars.newtroshop.web.dto.request.OrderedApiRequestDto;
import com.kostars.newtroshop.web.dto.response.OrderedApiResponseDto;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderApiController implements CrudInterface<OrderedApiRequestDto, OrderedApiResponseDto> {

    @Autowired
    private OrderService orderService;

    @Override
    @PostMapping()
    public Header<OrderedApiResponseDto> create(@RequestBody Header<OrderedApiRequestDto> request) {
        return orderService.create(request);
    }

    @Override
    @GetMapping(value = "{id}")
    public Header<OrderedApiResponseDto> read(@PathVariable Long id)
    {
        return orderService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<OrderedApiResponseDto> update(@RequestBody Header<OrderedApiRequestDto> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return null;
    }


}
