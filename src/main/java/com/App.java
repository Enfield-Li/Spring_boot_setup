package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import com.stream.Stream;
import com.stream.StreamRepository;
import com.viewer.Viewer;
import com.viewer.ViewerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext configContext = SpringApplication.run(App.class, args);

		StreamRepository streamRepo = configContext.getBean(StreamRepository.class);
		ViewerRepository viewerRepo = configContext.getBean(ViewerRepository.class);

		Stream newStream1 = new Stream("stream1");
		Stream newStream2 = new Stream("stream2");
		Stream newStream3 = new Stream("stream3");
		List<Stream> streamList = Arrays.asList(newStream1, newStream2, newStream3);

		Viewer newViewer1 = new Viewer("viewer1");
		Viewer newViewer2 = new Viewer("viewer2");
		Viewer newViewer3 = new Viewer("viewer3");
		List<Viewer> viewerList = Arrays.asList(newViewer1, newViewer2, newViewer3);

		streamRepo.saveAll(streamList);

		newViewer1.followedStream(newStream1);
		newViewer1.followedStream(newStream2);

		newViewer3.followedStream(newStream3);
		newViewer3.followedStream(newStream2);

		viewerRepo.saveAll(viewerList);
	}
}
