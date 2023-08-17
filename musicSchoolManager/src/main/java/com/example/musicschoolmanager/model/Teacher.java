package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.abstracts.AbstractTeacher;
import com.example.musicschoolmanager.model.enums.TeacherType;
import jakarta.persistence.*;
import lombok.*;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Teacher extends AbstractTeacher {

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<TeacherType> teacherTypes;

    @ElementCollection
    private List<String> knowledgeOfGuitarTechniques;

    public List<String> getKnowledgeOfGuitarTechniques(){
        if (!teacherTypes.contains(TeacherType.GUITAR)){
            throw new IllegalArgumentException("this teacher is not guitarist");
        }else {
            return this.knowledgeOfGuitarTechniques;
        }
    }
    public void setKnowledgeOfGuitarTechniques(List<String> knowledgeOfGuitarTechniques){
        if (!teacherTypes.contains(TeacherType.GUITAR)){
            throw new IllegalArgumentException("this teacher is not guitarist");
        }else {
            this.knowledgeOfDrumTechniques = knowledgeOfGuitarTechniques;
        }
    }
    @ElementCollection
    private List<String> drumInstruments;

    public List<String> getDrumInstruments(){
        if (!teacherTypes.contains(TeacherType.DRUM)){
            throw new IllegalArgumentException("this teacher is not drummer");
        }else {
            return this.drumInstruments;
        }
    }
    public void setDrumInstruments(List<String> drumInstruments){
        if (!teacherTypes.contains(TeacherType.DRUM)){
            throw new IllegalArgumentException("this teacher is not drummer");
        }else {
            this.drumInstruments = drumInstruments;
        }
    }

    @ElementCollection
    private List<String> knowledgeOfDrumTechniques;

    public List<String> getKnowledgeOfDrumTechniques(){
        if (!teacherTypes.contains(TeacherType.DRUM)){
            throw new IllegalArgumentException("this teacher is not drummer");
        }else {
            return this.drumInstruments;
        }
    }

    public void setKnowledgeOfDrumTechniques(List<String> knowledgeOfDrumTechniques){
        if (!teacherTypes.contains(TeacherType.DRUM)){
            throw new IllegalArgumentException("this teacher is not drummer");
        }else {
            this.knowledgeOfDrumTechniques = knowledgeOfDrumTechniques;
        }
    }

    @ElementCollection
    private List<String> knowledgeOfMusicalStyles;
    public List<String> getKnowledgeOfMusicalStyles(){
        if (!teacherTypes.contains(TeacherType.PIANO)){
            throw new IllegalArgumentException("this teacher is not pianist");
        }else {
            return this.knowledgeOfMusicalStyles;
        }
    }
    public void setKnowledgeOfMusicalStyles(List<String> knowledgeOfMusicalStyles){
        if (!teacherTypes.contains(TeacherType.PIANO)){
            throw new IllegalArgumentException("this teacher is not pianist");
        }else {
            this.knowledgeOfMusicalStyles = knowledgeOfMusicalStyles;
        }
    }

    @ElementCollection
    private List<String> musicalAchievements;

    public List<String> getMusicalAchievements(){
        if (!teacherTypes.contains(TeacherType.PIANO)){
            throw new IllegalArgumentException("this teacher is not pianist");
        }else {
            return this.musicalAchievements;
        }
    }
    public void setMusicalAchievements(List<String> musicalAchievements){
        if (!teacherTypes.contains(TeacherType.PIANO)){
            throw new IllegalArgumentException("this teacher is not pianist");
        }else {
            this.musicalAchievements = musicalAchievements;
        }
    }

}