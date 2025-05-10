package com.luvina.la.service.impl;

import com.luvina.la.dto.CertificationDTO;
import com.luvina.la.entity.Certification;
import com.luvina.la.repository.CertificationRepository;
import com.luvina.la.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation của dịch vụ lấy danh sách các tín chỉ.
 *
 * @author PhamToanThang
 */
@Service
public class CertificationServiceImpl implements CertificationService {
    @Autowired
    private CertificationRepository certificationRepository;

    /**
     * Lấy danh sách tất cả các tín chỉ.
     *
     * @return Map chứa mã phản hồi và danh sách tín chỉ.
     */
    @Override
    public Map<String, Object> getAllCertifications() {
        // Lấy tất cả tín chỉ từ repository
        List<Certification> certifications = certificationRepository.findAll();

        // Chuyển đổi từ entity sang DTO
        List<CertificationDTO> certificationDTOs = certifications.stream()
                .map(certification -> {
                    CertificationDTO certificationDTO = new CertificationDTO();
                    certificationDTO.setCertificationId(certification.getCertificationId());
                    certificationDTO.setCertificationName(certification.getCertificationName());
                    return certificationDTO;
                })
                .collect(Collectors.toList());

        // Tạo Map để trả về
        Map<String, Object> response = new HashMap<>();
        response.put("code", "200");
        response.put("certifications", certificationDTOs);
        return response;
    }
}
