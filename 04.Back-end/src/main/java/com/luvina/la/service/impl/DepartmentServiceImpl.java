package com.luvina.la.service.impl;

import com.luvina.la.dto.DepartmentDTO;
import com.luvina.la.entity.Department;
import com.luvina.la.repository.DepartmentRepository;
import com.luvina.la.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
     * @return Map chứa mã phản hồi và danh sách phòng ban.
     */
    @Override
    public Map<String, Object> getAllDepartments() {
        // Lấy tất cả phòng ban từ repository
        List<Department> departments = departmentRepository.findAll();

        // Chuyển đổi từ entity sang DTO
        List<DepartmentDTO> departmentDTOs = departments.stream()
                .map(department -> {
                    DepartmentDTO departmentDTO = new DepartmentDTO();
                    departmentDTO.setDepartmentId(department.getDepartmentId());
                    departmentDTO.setDepartmentName(department.getDepartmentName());
                    return departmentDTO;
                })
                .collect(Collectors.toList());

        // Tạo Map để trả về
        Map<String, Object> response = new HashMap<>();
        response.put("code", "200");
        response.put("departments", departmentDTOs);
        return response;
    }
}
