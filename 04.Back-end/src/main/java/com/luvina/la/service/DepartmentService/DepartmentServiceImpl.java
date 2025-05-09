package com.luvina.la.service.DepartmentService;

import com.luvina.la.dto.DepartmentDTO;
import com.luvina.la.entity.Department;
import com.luvina.la.repository.DepartmentRepository;
import com.luvina.la.service.DepartmentService.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation của dịch vụ lấy danh sách các phòng ban.
 *
 * @author PhamToanThang
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * Lấy danh sách tất cả các phòng ban.
     *
     * @return Danh sách các phòng ban dưới dạng DepartmentDTO.
     */
    @Override
    public List<DepartmentDTO> getAllDepartments() {
        // Lấy tất cả phòng ban từ repository
        List<Department> departments = departmentRepository.findAll();

        // Chuyển đổi từ entity sang DTO
        return departments.stream().map(department -> {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setDepartmentId(department.getDepartmentId());
            departmentDTO.setDepartmentName(department.getDepartmentName());
            return departmentDTO;
        }).collect(Collectors.toList());
    }
}
