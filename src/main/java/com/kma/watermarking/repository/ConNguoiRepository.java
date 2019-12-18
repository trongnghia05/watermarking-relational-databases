package com.kma.watermarking.repository;

import com.kma.watermarking.model.ConNguoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConNguoiRepository extends JpaRepository<ConNguoi, Long> {
  @Query("from ConNguoi")
  List<ConNguoi> getALl();
}
