package com.luvina.la.controller;

import com.luvina.la.dto.DepartmentDTO;
import com.luvina.la.dto.MessageDTO;
import com.luvina.la.dto.ResponseDTO;
import com.luvina.la.service.DepartmentService.DepartmentService;
import com.luvina.la.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller để xử lý các yêu cầu liên quan đến phòng ban.
 * Cung cấp các API để lấy danh sách phòng ban và xử lý lỗi.
 *
 * @author PhamToanThang
 */
@RestController
public class DepartmentController {

    /** Dịch vụ phòng ban */
    @Autowired
    private DepartmentService departmentService;

    /**
     * API lấy danh sách phòng ban.
     *
     * @param locale Ngôn ngữ yêu cầu (ví dụ: "vi", "ja"). Mặc định là "vi".
     * @return ResponseEntity chứa dữ liệu phòng ban hoặc thông báo lỗi nếu có lỗi xảy ra.
     */
    @GetMapping("/departments")
    public ResponseEntity<ResponseDTO> getDepartments(@RequestHeader(value = "Accept-Language", defaultValue = "vi") String locale) {
        // Thiết lập locale cho MessageUtil
        MessageUtil.setLocale(locale);

        ResponseDTO responseDTO = new ResponseDTO();

        try {
            // Lấy danh sách phòng ban từ dịch vụ
            List<DepartmentDTO> departmentDTOs = departmentService.getAllDepartments();
            responseDTO.setCode("200");
            responseDTO.setDepartments(departmentDTOs);
            return ResponseEntity.ok(responseDTO);

        } catch (Exception e) {
            // Xử lý lỗi, trả về mã lỗi và thông điệp
            responseDTO.setCode("500");
            MessageDTO message = new MessageDTO();
            message.setCode("ER023");

            // Lấy thông điệp lỗi từ resource bundle
            String msg = MessageUtil.getMessage("ER023");
            message.setParams(List.of(msg));

            responseDTO.setMessage(message);
            return ResponseEntity.status(500).body(responseDTO);
        }
    }

    /**
     * API lấy danh sách phòng ban giả lập lỗi 500.
     * (Được sử dụng để kiểm tra xử lý lỗi trong ứng dụng)
     *
     * @param locale Ngôn ngữ yêu cầu (ví dụ: "vi", "ja"). Mặc định là "vi".
     * @return ResponseEntity chứa dữ liệu phòng ban hoặc thông báo lỗi nếu có lỗi xảy ra.
     */
    // @GetMapping("/departments")
    // public ResponseEntity<ResponseDTO> getDepartments(@RequestHeader(value = "Accept-Language", defaultValue = "vi") String locale) {
    //     // Thiết lập locale cho MessageUtil
    //     MessageUtil.setLocale(locale);
    //
    //     ResponseDTO responseDTO = new ResponseDTO();
    //
    //     try {
    //         // Giả lập lỗi (trường hợp lỗi 500)
    //         throw new RuntimeException("Lỗi giả lập");
    //
    //         // Nếu không có lỗi, sẽ lấy danh sách phòng ban
    //         // List<DepartmentDTO> departmentDTOs = departmentService.getAllDepartments();
    //         // responseDTO.setCode("200");
    //         // responseDTO.setDepartments(departmentDTOs);
    //         // return ResponseEntity.ok(responseDTO);
    //
    //     } catch (Exception e) {
    //         // Trả về lỗi sử dụng mã lỗi và thông điệp từ MessageUtil
    //         responseDTO.setCode("500");
    //         MessageDTO message = new MessageDTO();
    //         message.setCode("ER023");
    //
    //         // Lấy message từ resource bundle
    //         String msg = MessageUtil.getMessage("ER023");
    //         message.setParams(List.of(msg));
    //
    //         responseDTO.setMessage(message);
    //         return ResponseEntity.status(500).body(responseDTO);
    //     }
    // }
}
