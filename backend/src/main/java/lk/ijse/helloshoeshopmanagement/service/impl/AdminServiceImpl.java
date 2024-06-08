package lk.ijse.helloshoeshopmanagement.service.impl;


import lk.ijse.helloshoeshopmanagement.dto.AdminDTO;
import lk.ijse.helloshoeshopmanagement.entity.Admin;
import lk.ijse.helloshoeshopmanagement.repo.AdminRepo;
import lk.ijse.helloshoeshopmanagement.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Double getTodayIncome() {
        return adminRepo.getTodayIncome();
    }

    @Override
    public void saveAdmin(AdminDTO adminDTO) {
        adminRepo.save(mapper.map(adminDTO, Admin.class));
    }
}
