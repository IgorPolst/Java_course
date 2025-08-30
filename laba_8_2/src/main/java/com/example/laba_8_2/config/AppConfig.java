package com.example.laba_8_2.config;

import java.text.SimpleDateFormat;
import java.util.*;

import com.example.laba_8_2.model.impl.HorrorBook;
import com.example.laba_8_2.model.impl.ScienceFictionBook;
import com.example.laba_8_2.model.impl.StoryBook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${story.book.ageGroup:Young Adult}")
    private String defaultAgeGroup;

    @Value("${default.book.available:true}")
    private boolean defaultAvailable;

    // Story Book bean - Singleton scope (default)
    @Bean
    public StoryBook storyBook() {
        StoryBook book = new StoryBook();
        book.setTitle("The Great Adventure");
        book.setAuthor("John Doe");
        book.setPages(256);
        book.setAgeGroup(defaultAgeGroup);
        book.setAvailable(defaultAvailable);

        List<String> tags = new ArrayList<>(Arrays.asList("adventure","coming-of-age","fantasy"));
        book.setTags(tags);

        book.setPublishDate(new Date(1577836800000L)); // Jan 1, 2020

        return book;
    }

    // Science Fiction Book bean - Prototype scope
    @Bean
    @Scope("prototype")
    public ScienceFictionBook scienceFictionBook() {
        ScienceFictionBook book = new ScienceFictionBook();
        book.setTitle("Space Odyssey");
        book.setAuthor("Jane Smith");
        book.setPages(422);
        book.setSubgenre("Space Opera");
        book.setAvailable(defaultAvailable);

        List<String> tags = new ArrayList<>(Arrays.asList("space","future","technology"));
        book.setTags(tags);

        Map<String, String> techTerms = new HashMap<>();
        techTerms.put("FTL", "Faster Than Light Travel");
        techTerms.put("AI", "Artificial Intelligence");
        techTerms.put("Terraform", "Process of making a planet habitable");
        book.setTechTerms(techTerms);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            book.setPublishDate(sdf.parse("2022-05-15"));
        } catch (Exception e) {
            book.setPublishDate(new Date());
        }

        return book;
    }

    // Alternate Science Fiction Book - For demonstrating @Qualifier
    @Bean
    public ScienceFictionBook alternateSciFiBook() {
        ScienceFictionBook book = new ScienceFictionBook();
        book.setTitle("Cybernetic Revolution");
        book.setAuthor("Robert Chen");
        book.setPages(368);
        book.setSubgenre("Cyberpunk");
        book.setAvailable(true);

        List<String> tags = new ArrayList<>(Arrays.asList("cyberpunk","dystopia","artificial-intelligence"));
        book.setTags(tags);

        Map<String, String> techTerms = new HashMap<>();
        techTerms.put("Neural Interface", "Direct brain-computer connection");
        techTerms.put("Cyberspace", "Virtual reality network");
        book.setTechTerms(techTerms);

        book.setPublishDate(new Date());

        return book;
    }

    // Horror Book bean
    @Bean
    public HorrorBook horrorBook() {
        HorrorBook book = new HorrorBook("Midnight Terror", "Mike Johnson");
        book.setPages(318);
        book.setScareRating(8);
        book.setContainsSupernaturalElements(true);
        book.setAvailable(false);

        List<String> tags = new ArrayList<>(Arrays.asList("horror","supernatural","thriller"));
        book.setTags(tags);

        book.setPublishDate(new Date(1609459200000L)); // Jan 1, 2021

        return book;
    }

    // Date formatter bean
    @Bean
    public SimpleDateFormat dateFormatter() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }
}