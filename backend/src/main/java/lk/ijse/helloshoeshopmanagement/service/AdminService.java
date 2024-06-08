package lk.ijse.helloshoeshopmanagement.service;


import lk.ijse.helloshoeshopmanagement.dto.AdminDTO;


public interface AdminService {
     Double getTodayIncome();
     void saveAdmin(AdminDTO adminDTO);


}
