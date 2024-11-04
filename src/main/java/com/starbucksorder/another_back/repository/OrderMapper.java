package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.dto.admin.response.Sales.RespSaleDto;
import com.starbucksorder.another_back.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    // 주문 저장
    int save(Order order);

    // 주문취소(주문상태바꾸기)
    int updateStatus(Order order);

    // FIXME: 사용되지 않는 로직인 거 같은데 확인 후 삭제하기
//    Long findOrderIdByUserId(Long userId);

    // 날짜를 기준으로 order 전체 들고오기
    List<Order> findByDate(Map<String, Object> map);

    RespSaleDto findByDateForSale();

    int countByDate(Map<String, Object> map);

    Order findOrderById(Long orderId);
}
