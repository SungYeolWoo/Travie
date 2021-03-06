package bit.project.imagic.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import bit.project.imagic.dao.FileUploadDAO;
import bit.project.imagic.vo.FileVO;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Inject
	FileUploadDAO dao;

	@Override
	public int isDir(FileVO file) throws Exception {
		return dao.select(file);
	}
	
	@Override
	public List<String> selectDir(FileVO file) throws Exception {
		return dao.selectDir(file);
	}
	
	@Override
	public int createDir(FileVO file) throws Exception {
		return dao.create(file);
	}

	@Override
	public int renameDir(FileVO file) throws Exception {
		return dao.rename(file);
	}

	@Override
	public int deleteDir(FileVO file) throws Exception {
		return dao.deleteDir(file);
	}

	@Override
	public List<FileVO> fileList(FileVO file) throws Exception {
		return dao.fileList(file);
	}

	@Override
	public int fileUpload(FileVO file) throws Exception {
		return dao.fileUpload(file);
	}

	@Override
	public String isFile(FileVO file) throws Exception {
		return dao.isFile(file);
	}
	
	@Override
	public int removeFile(FileVO file) throws Exception {
		return dao.removeFile(file);
	}

	@Override
	public int imgNumGet(FileVO file) throws Exception {
		return dao.imgNumGet(file);
	}

	@Override
	public FileVO fileDown(FileVO file) throws Exception {
		return dao.fileDown(file);
	}
}
