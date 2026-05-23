package com.donorlink.repository;

import com.donorlink.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    List<Donor> findByBloodGroupContainingIgnoreCaseOrCityContainingIgnoreCase(
            String bloodGroup,
            String city
    );
}
