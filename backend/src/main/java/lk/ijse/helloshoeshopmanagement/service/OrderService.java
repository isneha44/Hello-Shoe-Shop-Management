package lk.ijse.helloshoeshopmanagement.service;


import lk.ijse.helloshoeshopmanagement.dto.CustomDTO;
import lk.ijse.helloshoeshopmanagement.dto.SaleDTO;
import lk.ijse.helloshoeshopmanagement.dto.SaleDetailsDTO;
import lk.ijse.helloshoeshopmanagement.entity.SaleDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


public interface OrderService {

    void placeOrder(@RequestBody SaleDTO dto);
    ArrayList<SaleDTO> LoadOrders();
    ArrayList<SaleDetailsDTO> LoadOrderDetails();
    //Double getTodayIncome();
    int getTodayOrders();
    int getDayOrderQty();

    List<SaleDTO> findAllSalesForToday();

    @ResponseBody
    CustomDTO OrderIdGenerate();
    void returnOrder(@RequestBody SaleDTO dto);
    SaleDTO searchOrder(String code);
    @ResponseBody
    CustomDTO getSumOrders();

    SaleDetails getOrderById(String id);

    List<Object[]> getTopSellItemsForToday() ;

}
