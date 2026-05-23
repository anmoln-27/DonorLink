package com.donorlink.service;

import com.donorlink.model.Donor;
import com.donorlink.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonorService {

    private final DonorRepository donorRepository;

    // Get all donors
    public List<Donor> getAll() {

        return donorRepository.findAll();
    }

    // Add donor
    public void addDonor(Donor donor) {

        donorRepository.save(donor);
    }

    // Delete donor
    public void deleteDonor(Long id) {

        donorRepository.deleteById(id);
    }

    // Get donor by ID
    public Donor getDonorById(Long id) {

        return donorRepository.findById(id).orElse(null);
    }

    // Search donor
    public List<Donor> search(String keyword) {

        return donorRepository
                .findByBloodGroupContainingIgnoreCaseOrCityContainingIgnoreCase(
                        keyword,
                        keyword
                );
    }

    // Count available donors
    public long availableCount() {

        return donorRepository.findAll()
                .stream()
                .filter(Donor::isAvailability)
                .count();
    }

    // Match donors for requests
    public List<Donor> match(String bloodGroup, String city) {

        return donorRepository
                .findByBloodGroupContainingIgnoreCaseOrCityContainingIgnoreCase(
                        bloodGroup,
                        city
                );
    }
}
