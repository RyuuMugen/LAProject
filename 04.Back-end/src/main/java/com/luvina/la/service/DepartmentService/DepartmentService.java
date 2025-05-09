package com.luvina.la.service.DepartmentService;

import com.luvina.la.dto.DepartmentDTO;
import java.util.List;

/**
 * Interface dịch vụ để lấy danh sách các phòng ban.
 *
 * @author PhamToanThang
 */
public interface DepartmentService {

    /**
     * Lấy danh sách tất cả các phòng ban.
     *
     * @return Danh sách các phòng ban dưới dạng DepartmentDTO.
     */
    List<DepartmentDTO> getAllDepartments();
}
