package com.dong.cbu.dao;

import com.dong.cbu.model.OrderTable;

import java.util.List;

/**
 * Created by zhendong on 2016/5/5.
 * email:myyizhendong@gmail.com
 */
public interface OrderTableMapper {
    int order(OrderTable ordertable);
    List<OrderTable> showCheck(int id);
}
