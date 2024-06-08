package lk.ijse.helloshoeshopmanagement.service;


import lk.ijse.helloshoeshopmanagement.dto.CustomDTO;
import lk.ijse.helloshoeshopmanagement.dto.SupplierDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

public interface SupplierService {

    void saveSupplier(SupplierDTO dto);
    void updateSupplier(SupplierDTO dto);
    void deleteSupplier(String id);
    SupplierDTO searchSupId(String id);
    SupplierDTO searchSupId(String code, String name);
    ArrayList<SupplierDTO> loadAllSupplier();

    @ResponseBody
    CustomDTO supplierIdGenerate();
    SupplierDTO getSumSupplier();

}
