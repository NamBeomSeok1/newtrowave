package com.kostars.newtroshop.web.dto;


import com.kostars.newtroshop.domain.CrudInterface;
import com.kostars.newtroshop.domain.Header;
import com.kostars.newtroshop.service.OrderService;
import com.kostars.newtroshop.web.dto.request.OrderApiRequestDto;
import com.kostars.newtroshop.web.dto.response.OrderApiResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderApiController implements CrudInterface<OrderApiRequestDto, OrderApiResponseDto> {

    @Autowired
    private OrderService orderService;

    @Override
    @PostMapping()
    public Header<OrderApiResponseDto> create(@RequestBody Header<OrderApiRequestDto> request) {
        return orderService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<OrderApiResponseDto> read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header<OrderApiResponseDto> update(@RequestBody Header<OrderApiRequestDto> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
