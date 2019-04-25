package spe.placement_portal.services;



import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import spe.placement_portal.exception.StorageException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {
	
	public boolean updateCv(String fileName,MultipartFile cv)
	{
		boolean result=true;
		try
		{
	        if (cv.isEmpty()) {
	            throw new StorageException("Failed to store empty file");
	        }
            InputStream is = cv.getInputStream();
            String path = "";
            System.out.println("storage service");
            if (System.getProperty("os.name").toLowerCase().contains("windows")) 
            	path = "C:\\cv\\";
            else path = "/home/abhay/Desktop/cv/";
            
            Path dest=Paths.get(path+fileName);
            
            System.out.println("Saving " + fileName + " in " + path + " .");
            
            Files.copy(is, dest,
                    StandardCopyOption.REPLACE_EXISTING);
		}catch(Exception e)
		{
			result=false;
		      String msg = String.format("Failed to store file", cv.getName());

	          throw new StorageException(msg, e);
		}
		return result;
	}
}
