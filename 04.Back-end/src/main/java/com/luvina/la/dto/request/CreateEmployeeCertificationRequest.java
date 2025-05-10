package com.luvina.la.dto.request;
/**
 * Lớp DTO dùng để truyền dữ liệu cho chứng chỉ của nhân viên.
 */
public class CreateEmployeeCertificationRequest {

    /** Tên chứng chỉ */
    private String certificationName;

    /** Ngày hết hạn chứng chỉ */
    private String endDate;

    /** Điểm số chứng chỉ */
    private String score;

    /**
     * Constructor đầy đủ tham số để khởi tạo đối tượng CreateCertificationRequest.
     *
     * @param certificationName Tên chứng chỉ
     * @param endDate           Ngày hết hạn chứng chỉ
     * @param score             Điểm số chứng chỉ
     */
    public CreateEmployeeCertificationRequest(String certificationName, String endDate, String score) {
        this.certificationName = certificationName;
        this.endDate = endDate;
        this.score = score;
    }

    // Getters and Setters...

    public String getCertificationName() {
        return certificationName;
    }

    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
