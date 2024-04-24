package io.github.io.github.terminological;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import uk.co.terminological.rjava.RConverter;
import uk.co.terminological.rjava.types.RCharacter;
import uk.co.terminological.rjava.types.RCharacterVector;

public class TestWrite {

	private RCharacter out(String name) {
		Path p = Paths.get(System.getProperty("user.home"),"tmp",name);
		try {
			Files.createDirectories(p.getParent());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return RCharacter.from(p.toString());
	}
	
	@Test
	public void test() throws URISyntaxException, IOException {
		Path in = Paths.get(TestWrite.class.getResource("/example.plantuml").toURI());
		RCharacterVector tmp = Files.lines(in).collect(RConverter.stringCollector());
		PlantUML.savePlantUml(tmp, out("example.png"), RCharacter.from("png"));
	}

}
