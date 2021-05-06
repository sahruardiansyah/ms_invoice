package com.nsr.invoice.controller;


import com.nsr.invoice.entity.Cinema;
import com.nsr.invoice.mgr.CinemaManager;
import com.nsr.invoice.model.UpdateCinemaRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cinema")
@Validated
public class CinemaController {

	private static Logger logger = LoggerFactory.getLogger(CinemaController.class);
	@Autowired
	CinemaManager cinemaService;



	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/")
	public List<Cinema> getAllCinema() {
		return cinemaService.getAllCinema();
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/")
	public Cinema createCinema(@Valid @RequestBody Cinema cinema) {
		logger.info("create cinema request : "+cinema);
		return cinemaService.addCinema(cinema);
	}
	

	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/{cinemaId}")
	public Cinema updateCinema(@PathVariable String cinemaId ,@RequestBody UpdateCinemaRequest cinemaRequest) {
		logger.info("cinema id request : "+cinemaId);
		logger.info("update cinema request : "+cinemaRequest);
		Cinema cinema = cinemaService.getCinemaById(cinemaId);
		cinema.setAlamat(cinemaRequest.getAlamat());
		cinema.setEmail(cinemaRequest.getAlamat());
		cinema.setKeterangan(cinemaRequest.getKeterangan());
		cinema.setKota(cinemaRequest.getKota());
		cinema.setNama(cinemaRequest.getNama());
		cinema.setNoHp(cinemaRequest.getNoHp());
		cinema.setTipe(cinemaRequest.getTipe());
		return cinemaService.addCinema(cinema);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/{cinemaId}")
	public Cinema getCinemaById(@PathVariable String  cinemaId) {
		logger.info("cinema id request : "+cinemaId);
		return cinemaService.getCinemaById(cinemaId);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/{cinemaId}")
	public void deleteCinemaById(@PathVariable String  cinemaId) {
		logger.info("cinema id request : "+cinemaId);
		cinemaService.deleteCinemaById(cinemaId);
	}

}
