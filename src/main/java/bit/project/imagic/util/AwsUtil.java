package bit.project.imagic.util;

import java.io.ByteArrayInputStream;



import java.io.InputStream;
import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class AwsUtil {
	
	public static String SUFFIX = "/";
	
	public static boolean createS3Folder(String bucketName, String folderName, AmazonS3 client) {
		// create meta-data for your folder and set content-length to 0
		try {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(0);
			// create empty content
			InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
			// create a PutObjectRequest passing the folder name suffixed by /
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
						folderName + SUFFIX, emptyContent, metadata);
			// send request to S3 to create folder
			client.putObject(putObjectRequest);
			return true;
		} catch (AmazonS3Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
public static boolean renameS3Folder(String bucketName, String user_id, String source, String destination, AmazonS3Client s3){
		
	try {
		String source_src = user_id + AwsUtil.SUFFIX + source +  AwsUtil.SUFFIX;
		String dest_src = user_id + AwsUtil.SUFFIX + destination + AwsUtil.SUFFIX;
		
		ObjectListing fileList = s3.listObjects(bucketName, source_src);
		
		List<S3ObjectSummary> list = fileList.getObjectSummaries();

		CopyObjectRequest cor;
		for (S3ObjectSummary file : list) {
			
			if (!file.getKey().equals(source_src)) {
				int separate_index = file.getKey().lastIndexOf("/") + 1;
				String file_name = file.getKey().substring(separate_index);
				dest_src = dest_src + file_name;
			}
			cor = new CopyObjectRequest(bucketName, file.getKey(), bucketName, dest_src);
			s3.copyObject(cor);
		}
		deleteS3Folder(bucketName, source_src, s3);
		return true;
	} catch (AmazonS3Exception e) {
		return false;
	}
}
	
public static boolean deleteS3Folder(String bucketName, String folderName, AmazonS3Client s3) {
	try {
		List<S3ObjectSummary> fileList = 
				s3.listObjects(bucketName, folderName).getObjectSummaries();
		for (S3ObjectSummary file : fileList) {
			System.out.println(file.getKey());
			s3.deleteObject(bucketName, file.getKey());
		}
		return true;
	} catch (AmazonS3Exception e){
		return false;
	}
}
	
}
