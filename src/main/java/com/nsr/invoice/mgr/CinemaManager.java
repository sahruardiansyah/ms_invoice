package com.nsr.invoice.mgr;

import com.nsr.commons.exception.NsrException;
import com.nsr.invoice.entity.Cinema;
import com.nsr.invoice.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaManager {
    @Autowired
    CinemaRepository cinemaRepository;

    public Cinema addCinema(Cinema cinema) {
        // TODO Auto-generated method stub
        return cinemaRepository.save(cinema);
    }

    public Cinema getCinemaById(String cinemaId) {
        // TODO Auto-generated method stub
        return cinemaRepository.findById(cinemaId).orElseThrow(()->new NsrException(String.format("Cinema with id: %s nnot found!",cinemaId)));
    }

    public List<Cinema> getAllCinema() {
        // TODO Auto-generated method stub
        return (List<Cinema>) cinemaRepository.findAll();
    }

    public void deleteCinemaById(String cinemaId) {
        cinemaRepository.deleteById(cinemaId);

    }
}
