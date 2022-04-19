package com.stream;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.viewer.Viewer;

@Entity
public class Stream {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "followedStreams") // maped by specify property ownning relationship
    private List<Viewer> followers = new ArrayList<>();

    public Stream(String name) {
        this.name = name;
    }

    public void addViewer(Viewer viewer) {
        followers.add(viewer);
    }
        
}
