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
	
	public static boolean createS3Folder(String bucketName, String m_id, String folderName, AmazonS3Client s3) {
		// create meta-data for your folder and set content-length to 0
		try {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(0);
			// create empty content
			InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
			// create a PutObjectRequest passing the folder name suffixed by /
			String key;
			
			if (folderName.isEmpty() || folderName.equals("") || folderName == null) {
				key = null;
			} else {
				key = m_id + AwsUtil.SUFFIX + folderName + AwsUtil.SUFFIX;
			}
			if (!isFolderTest(bucketName, m_id, key, s3)) {
				PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
							key, emptyContent, metadata);
				// send request to S3 to create folder
				s3.putObject(putObjectRequest);
				return true;
			} else {
				return false;
			}
			
//			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
//						folderName + SUFFIX, emptyContent, metadata);
//			 send request to S3 to create folder
//			s3.putObject(putObjectRequest);
//			return true;
		} catch (AmazonS3Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
public static boolean renameS3Folder(String bucketName, String m_id, String source, String destination, AmazonS3Client s3){
		
	try {
		String source_src = m_id + AwsUtil.SUFFIX + source +  AwsUtil.SUFFIX;
		String dest_src = m_id + AwsUtil.SUFFIX + destination + AwsUtil.SUFFIX;
		
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
		deleteS3Folder(bucketName, m_id, source, s3);
		return true;
	} catch (AmazonS3Exception e) {
		return false;
	}
}
	
public static boolean deleteS3Folder(String bucketName, String m_id, String folderName, AmazonS3Client s3) {
	try {
		String src = m_id + AwsUtil.SUFFIX + folderName +  AwsUtil.SUFFIX;
		List<S3ObjectSummary> fileList = 
				s3.listObjects(bucketName, folderName).getObjectSummaries();
		for (S3ObjectSummary file : fileList) {
			System.out.println(file.getKey());
			s3.deleteObject(src, file.getKey());
		}
		return true;
	} catch (AmazonS3Exception e){
		return false;
	}
}

public static boolean isFolderTest(String bucketName, String m_id, String key, AmazonS3Client s3) {
	ObjectListing fileList;
	
	// key값이 없다면 bucket에 m_id폴더 생성인 경우임
	if(key == null || key.equals("") || key.isEmpty()) {
		fileList = s3.listObjects(bucketName);	
	} else {
		fileList = s3.listObjects(bucketName, m_id + AwsUtil.SUFFIX);
	}
	
	List<S3ObjectSummary> list = fileList.getObjectSummaries();
	for (S3ObjectSummary file : list) {
		if (file.getKey().equals(key)) {
			return true;
		}
	}
	return false;
}	

}
