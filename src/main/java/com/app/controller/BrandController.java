package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Brand;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.BrandRepository;

@RestController
@RequestMapping("/api/v2/")
public class BrandController {

	@Autowired
	private BrandRepository brandRepository;

	// get all Brand
	@GetMapping("/brands")
	public List<Brand> getAllBrands() {
		return brandRepository.findAll();

	}

	// create Brand rest api
	@PostMapping("/brand")
	public Brand createProduct(@RequestBody Brand brand) {
		return brandRepository.save(brand);
	}

	@GetMapping("/brand/{id}")
	public ResponseEntity<Brand> getBrandById(@PathVariable int id) {
		Brand brand = brandRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brand not exist with id :" + id));
		return ResponseEntity.ok(brand);
	}

	// update Brand rest api
	@PutMapping("/brand/{id}")
	public ResponseEntity<Brand> updateBrand(@PathVariable int id, @RequestBody Brand brandDetails) {
		Brand brand = brandRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brand not exits with id:" + id));
		brand.setId(brandDetails.getId());
		brand.setBrandName(brandDetails.getBrandName());
		Brand updateBrand = brandRepository.save(brand);
		return ResponseEntity.ok(updateBrand);

	}

	// delete Brand rest api
	@DeleteMapping("/Brand/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBrand(@PathVariable int id) {
		Brand brand = brandRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brand not exits with id:" + id));
		brandRepository.delete(brand);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
