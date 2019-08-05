package kosta.mvc.model.movie.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {	
	private long movieNo;
	private String movieName;
	private String movieGenre;
	private String movieStory;
	private String movieActor;
	private String movieDirector;
	private String fname;
	private long fsize;
	private MultipartFile File;
}
