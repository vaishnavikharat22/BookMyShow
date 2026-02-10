package com.cfs.bms.service;

import com.cfs.bms.dto.TheaterDto;
import com.cfs.bms.exception.ResourceNotFoundException;
import com.cfs.bms.model.Theater;
import com.cfs.bms.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public TheaterDto createTheater(TheaterDto theaterDto){

        Theater theater = mapToEntity(theaterDto);
        Theater savedTheater= theaterRepository.save(theater);
        return mapToDto(savedTheater);
    }

    public TheaterDto getTheaterById(Long id){

        Theater theater = theaterRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Theater not found with id: " + id));
        return mapToDto(theater);
    }

   public List<TheaterDto> getAllTheaters(){

        List<Theater> theaters = theaterRepository.findAll();
        return theaters.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<TheaterDto> getAllTheaterByCity(String city){

        List<Theater> theaters = theaterRepository.findByCity(city);
        return theaters.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }


   public TheaterDto updateTheater(Long id, TheaterDto theaterDto){

        Theater theater = theaterRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Theater not found with id : " + id));

        theater.setName(theaterDto.getName());
        theater.setAddress(theaterDto.getAddress());
        theater.setCity(theaterDto.getCity());
        theater.setTotalScreen(theaterDto.getTotalScreens());

        Theater updatedTheater = theaterRepository.save(theater);
        return mapToDto(updatedTheater);
   }


    public void deleteTheater(Long id) {
        if (!theaterRepository.existsById(id)) {
            throw new ResourceNotFoundException("Theater not found with id : " + id);
        }
        theaterRepository.deleteById(id);
    }

    private TheaterDto mapToDto(Theater theater) {
        TheaterDto theaterDto = new TheaterDto();
        theaterDto.setId(theater.getId());
        theaterDto.setName(theater.getName());
        theaterDto.setCity(theater.getCity());
        theaterDto.setAddress(theater.getAddress());
        theaterDto.setTotalScreens(theater.getTotalScreen());
        return theaterDto;
    }

    private Theater mapToEntity(TheaterDto theaterDto) {

        Theater theater = new Theater();
        theater.setName(theaterDto.getName());
        theater.setAddress(theaterDto.getAddress());
        theater.setCity(theaterDto.getCity());
        theater.setTotalScreen(theaterDto.getTotalScreens());
        return theater;
    }
}
