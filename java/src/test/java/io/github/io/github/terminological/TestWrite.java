package io.github.io.github.terminological;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import uk.co.terminological.rjava.RConverter;
import uk.co.terminological.rjava.types.RCharacter;
import uk.co.terminological.rjava.types.RCharacterVector;
import uk.co.terminological.rjava.types.RFile;

public class TestWrite {

	private RFile out(String name) {
		Path p = Paths.get(System.getProperty("user.home"),"tmp",name);
		try {
			Files.createDirectories(p.getParent());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return RFile.from(p);
	}
	
	@Test
	public void test() throws URISyntaxException, IOException {
		Path in = Paths.get(TestWrite.class.getResource("/example.plantuml").toURI());
		RCharacterVector tmp = Files.lines(in).collect(RConverter.stringCollector());
		PlantUML.savePlantUml(tmp, out("example.png"), RCharacter.from("png"));
		assertTrue(Files.exists(out("example.png").get()));
	}

}
