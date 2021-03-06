package com.infrabookingapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infrabookingapp.entity.Booking;
import com.infrabookingapp.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/booking")
	public ResponseEntity<List<Booking>> getAllBookings(){
		return new ResponseEntity<List<Booking>>(this.bookingService.getAllBookings(), HttpStatus.OK);
	}
	
	@GetMapping("/booking/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable(name="id") int id){
		return new ResponseEntity<Booking>(this.bookingService.getBookingById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/addBooking")
	public ResponseEntity<Booking> addOlxUser(@RequestBody Booking booking) {
		return new ResponseEntity<Booking>(this.bookingService.addBooking(booking),HttpStatus.CREATED);
	}

}
