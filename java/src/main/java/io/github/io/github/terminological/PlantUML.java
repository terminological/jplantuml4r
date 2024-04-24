package io.github.io.github.terminological;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.OptionFlags;
import net.sourceforge.plantuml.SourceStringReader;
import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RConverter;
import uk.co.terminological.rjava.RDefault;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.RCharacter;
import uk.co.terminological.rjava.types.RCharacterVector;

/**
 * PlantUML can generate a variety of diagrams from a DSL
 */
@RClass(suggests = {"devtools","here"})
public class PlantUML {

	static Logger log = LoggerFactory.getLogger(PlantUML.class);
	
	/**
	 * Render a plantuml file to a png file 
	 * @param plantuml a plantuml file as a character vector.
	 * @param outFile the output filename
	 * @param format see supported_formats method
	 * @return this java method returns the message that the object was created with 
	 * @throws IOException if the PNG cannot be written
	 */
	@RMethod
	public static RCharacter savePlantUml(
			RCharacterVector plantuml, 
			@RDefault(rCode="tempfile()") RCharacter outFile, 
			@RDefault(rCode = "'png'") RCharacter format
			) throws IOException {
		OptionFlags.getInstance().setOverwrite(true);
		Files.createDirectories(Paths.get(outFile.get()).getParent());
		OutputStream png = new FileOutputStream(outFile.get());
		FileFormat ff = FileFormat.valueOf(format.get().toUpperCase());
		SourceStringReader reader = new SourceStringReader(plantuml.get().collect(Collectors.joining("\n")));
		// Write the first image to "png"
		reader.outputImage(png, new FileFormatOption(ff));
		return outFile;
		
	}
	
	/**
	 * Get the list of supported formats for plantuml 
	 * @return a list of formats.
	 */
	@RMethod
	public static RCharacterVector supportedFormats() {
		return Arrays
			.stream(FileFormat.values())
			.map(ff -> ff.toString())
			.collect(RConverter.stringCollector());
	}
	
	
}
