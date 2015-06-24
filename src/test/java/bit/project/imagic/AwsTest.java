package bit.project.imagic;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import bit.project.imagic.util.AwsUtil;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
//@RunWith(SpringJUnit4ClassRunner.class)
public class AwsTest {
	String AWS_BUCKET_NAME = "travie";
	String AWS_ACCESS_KEY = "AKIAJN2LH36EY7SNAHVQ";
	String AWS_SECRETKEY = "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";
	
	AWSCredentials credentials = new BasicAWSCredentials(AWS_ACCESS_KEY,AWS_SECRETKEY);
	
	AmazonS3 s3 = new AmazonS3Client(credentials);
	
//	@Test
	public void ListTest() {
		ObjectListing fileList = s3.listObjects(AWS_BUCKET_NAME, "aaaa/");
		
		List<S3ObjectSummary> list = fileList.getObjectSummaries();
		S3Object s3Obj;
		for (S3ObjectSummary file : list) {
			System.out.println(file.getKey());
//			s3.deleteObject(AWS_BUCKET_NAME, file.getKey());
			s3Obj = s3.getObject(AWS_BUCKET_NAME, file.getKey());
			System.out.println(s3Obj);
		}
//		s3.deleteObject(AWS_BUCKET_NAME, "aaaa");
		assertEquals(0, 0);
	}
	
	
	@Test
	public void CopyObjectTest() {
//		RenameFolder("aaaa", "qqq", "qwe");
		assertEquals(0, 0);
	}
	
	public void RenameFolder(String user_id, String source, String destination){
		
		String source_src = user_id + AwsUtil.SUFFIX + source +  AwsUtil.SUFFIX;
		String dest_src = user_id + AwsUtil.SUFFIX + destination + AwsUtil.SUFFIX;
		
		ObjectListing fileList = s3.listObjects(AWS_BUCKET_NAME, source_src);
		
		List<S3ObjectSummary> list = fileList.getObjectSummaries();

		CopyObjectRequest cor;
		for (S3ObjectSummary file : list) {
			
			if (!file.getKey().equals(source_src)) {
				int separate_index = file.getKey().lastIndexOf("/") + 1;
				String file_name = file.getKey().substring(separate_index);
				dest_src = dest_src + file_name;
			}
			cor = new CopyObjectRequest(AWS_BUCKET_NAME, file.getKey(), AWS_BUCKET_NAME, dest_src);
			s3.copyObject(cor);
		}
		deleteFolder(source_src);
	}
	
	
	public void deleteFolder(String folderName) {
		System.out.println(folderName);
		List<S3ObjectSummary> fileList = 
				s3.listObjects(AWS_BUCKET_NAME, folderName).getObjectSummaries();
		for (S3ObjectSummary file : fileList) {
			System.out.println(file.getKey());
			s3.deleteObject(AWS_BUCKET_NAME, file.getKey());
		}
//		s3.deleteObject(AWS_BUCKET_NAME, folderName);
	}
}
