package com.durotan.repository;

import com.durotan.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Long> {
    public List<Color> findByColorNameIn(List<String> colorName);
}
