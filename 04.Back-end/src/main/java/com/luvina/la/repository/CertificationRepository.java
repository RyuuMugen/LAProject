package com.luvina.la.repository;

import com.luvina.la.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository để xử lý các thao tác với entity Certìfication.
 * Cung cấp các phương thức để truy vấn và thao tác với bảng chứng chỉ trong cơ sở dữ liệu.
 *
 * @author PhamToanThang
 */
@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {

}
