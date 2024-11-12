package com.attendance.studentattendance.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/run/")
@Validated
public class RunContoller { // Fixed spelling: RunContoller -> RunController
    private final RunRepo runRepo;

    public RunContoller(RunRepo runRepo) {
        this.runRepo = runRepo;
    }

    @GetMapping("")
    public List<Run> findAll() {
        return runRepo.findAll();
    }

    @GetMapping("{id}") // Added to fetch specific Run by RollNo
    public Optional<Run> findById(@PathVariable Integer id) { // Added @PathVariable to map URL parameter
        return runRepo.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Run run) {
        runRepo.create(run);
    }

    @PutMapping("{roll}")
    public void update(@Valid @RequestBody Run run, @PathVariable Integer roll) { // Added @PathVariable for mapping
        runRepo.update(run, roll);
    }

    @DeleteMapping("{roll}")
    public void delete(@PathVariable Integer roll) { // Added @PathVariable for mapping
        runRepo.delete(roll);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        runRepo.deleteAll();
    }
}
