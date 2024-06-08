package lk.ijse.helloshoeshopmanagement.controller;



import lk.ijse.helloshoeshopmanagement.dto.AdminDTO;
import lk.ijse.helloshoeshopmanagement.service.AdminService;
import lk.ijse.helloshoeshopmanagement.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/todayIncome")
    public ResponseUtil getTodayIncome() {
        AdminDTO adminDTO = new AdminDTO();
        Double todayIncome = adminService.getTodayIncome();
        adminDTO.setTodayTotal(todayIncome);
        return new ResponseUtil("OK", "Successfully Loaded Income.", todayIncome);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveAdminPanel(@ModelAttribute AdminDTO adminDTO){
         adminService.saveAdmin(adminDTO);
        return new ResponseUtil("OK", "Successfully Loaded Income.",null);
    }

}
