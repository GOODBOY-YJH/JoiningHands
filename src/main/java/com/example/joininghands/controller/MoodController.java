package com.example.joininghands.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mood")
@Tag(name = "MoodController", description = "心情Web接口")
public class MoodController {
}
