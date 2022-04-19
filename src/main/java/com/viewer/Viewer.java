package com.viewer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.stream.Stream;

@Entity
public class Viewer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;

    @ManyToMany
    @JoinTable(
        name = "followed_streams",
        joinColumns = @JoinColumn(name = "viewer_id"),
        inverseJoinColumns = @JoinColumn(name = "stream_id")
    )
    private List<Stream> followedStreams = new ArrayList<>();

    public Viewer(String nickname) {
        this.nickname = nickname;
    }
    
    public void followedStream(Stream stream) {
        followedStreams.add(stream);
    }
}
