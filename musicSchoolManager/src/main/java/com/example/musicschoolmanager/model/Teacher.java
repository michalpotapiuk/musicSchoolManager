package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.abstracts.AbstractTeacher;
import com.example.musicschoolmanager.model.enums.TeacherType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends AbstractTeacher {

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    @Column(name = "teacherType", nullable = false)
    private Set<TeacherType> teacherTypes;

    @ElementCollection
    private List<String> knowledgeOfGuitarTechniques;

    public List<String> getKnowledgeOfGuitarTechniques() throws Exception {
        if (checkTeacherType(TeacherType.GUITAR)){
            throw new Exception("this teacher is not guitarist");
        }else {
            return this.knowledgeOfGuitarTechniques;
        }
    }
    public void setKnowledgeOfGuitarTechniques(List<String> knowledgeOfGuitarTechniques) throws Exception {
        if (checkTeacherType(TeacherType.GUITAR)){
            throw new Exception("this teacher is not guitarist");
        }else {
            this.knowledgeOfDrumTechniques = knowledgeOfGuitarTechniques;
        }
    }

    @ElementCollection
    private List<String> drumInstruments;

    public List<String> getDrumInstruments() throws Exception {
        if (checkTeacherType(TeacherType.DRUM)){
            throw new Exception("this teacher is not drummer");
        }else {
            return this.drumInstruments;
        }
    }
    public void setDrumInstruments(List<String> drumInstruments) throws Exception {
        if (checkTeacherType(TeacherType.DRUM)){
            throw new Exception("this teacher is not drummer");
        }else {
            this.drumInstruments = drumInstruments;
        }
    }

    @ElementCollection
    private List<String> knowledgeOfDrumTechniques;

    public List<String> getKnowledgeOfDrumTechniques() throws Exception {
        if (checkTeacherType(TeacherType.DRUM)){
            throw new Exception("this teacher is not drummer");
        }else {
            return this.drumInstruments;
        }
    }

    public void setKnowledgeOfDrumTechniques(List<String> knowledgeOfDrumTechniques) throws Exception {
        if (checkTeacherType(TeacherType.DRUM)){
            throw new Exception("this teacher is not drummer");
        }else {
            this.knowledgeOfDrumTechniques = knowledgeOfDrumTechniques;
        }
    }

    @ElementCollection
    private List<String> knowledgeOfMusicalStyles;
    public List<String> getKnowledgeOfMusicalStyles() throws Exception {
        if (checkTeacherType(TeacherType.PIANO)){
            throw new Exception("this teacher is not pianist");
        }else {
            return this.knowledgeOfMusicalStyles;
        }
    }
    public void setKnowledgeOfMusicalStyles(List<String> knowledgeOfMusicalStyles) throws Exception {
        if (checkTeacherType(TeacherType.PIANO)){
            throw new Exception("this teacher is not pianist");
        }else {
            this.knowledgeOfMusicalStyles = knowledgeOfMusicalStyles;
        }
    }

    @ElementCollection
    private List<String> musicalAchievements;

    public List<String> getMusicalAchievements() throws Exception {
        if (checkTeacherType(TeacherType.PIANO)){
            throw new Exception("this teacher is not pianist");
        }else {
            return this.musicalAchievements;
        }
    }
    public void setMusicalAchievements(List<String> musicalAchievements) throws Exception {
        if (checkTeacherType(TeacherType.PIANO)){
            throw new Exception("this teacher is not pianist");
        }else {
            this.musicalAchievements = musicalAchievements;
        }
    }

    private boolean checkTeacherType(TeacherType teacherType) {
        return !teacherTypes.contains(teacherType);
    }
}