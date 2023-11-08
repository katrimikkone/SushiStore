package backend.sushistore.web;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend.sushistore.domain.Image;
import backend.sushistore.domain.ImageRepository;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private ImageRepository irepository;

	@GetMapping(value="/display/{symbolid}")
	@ResponseBody
	void showImage(@PathVariable("symbolid") Long symbolid, HttpServletResponse response, Optional<Image> image) throws IOException
		 {
		image = irepository.findById(symbolid);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(image.get().getImagedata());
		response.getOutputStream().close();
	}
}
