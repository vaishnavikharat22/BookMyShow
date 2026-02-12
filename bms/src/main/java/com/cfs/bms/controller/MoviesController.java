package com.cfs.bms.controller;

import com.cfs.bms.dto.MovieDto;
import com.cfs.bms.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")

public class MoviesController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto) {

        return new ResponseEntity<>(movieService.createMovie(movieDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id)
    {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies()
    {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<MovieDto> updateMovie(@PathVariable Long id, @Valid @RequestBody MovieDto movieDto)
//    {
//        return ResponseEntity.ok(movieService.updateMovie(id, movieDto));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
//        movieService.deleteMovie(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<List<MovieDto>> searchMovies(@RequestParam String title) {
//        return ResponseEntity.ok(movieService.searchMovies(title));
//    }
}