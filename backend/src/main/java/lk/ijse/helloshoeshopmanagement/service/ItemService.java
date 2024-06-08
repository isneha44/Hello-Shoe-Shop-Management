package lk.ijse.helloshoeshopmanagement.service;



import lk.ijse.helloshoeshopmanagement.dto.CustomDTO;
import lk.ijse.helloshoeshopmanagement.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {

    void saveItem(ItemDTO dto);
    void updateItem(ItemDTO dto);
    void deleteItem(String id);
    ItemDTO searchItemId(String code, String name);
    ItemDTO searchItemId(String code);
    ArrayList<ItemDTO> loadAllItem();
    CustomDTO getItemCount();
    Double getTodayExpectedProfit();

    CustomDTO getItemQty();
}
