package bit.project.imagic.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import bit.project.imagic.service.SortService;
import bit.project.imagic.vo.FileVO;

@Controller
@SessionAttributes("file")
public class SortableController {
	
	@Inject
	private SortService sortService;
	FileVO file;
	
	public SortableController() {
		file = new FileVO();
	}
	
	// 파일 저장 기본 경로
	//	String path = "/Users/ProgrammingPearls/Documents/Upload/";
	String path = "d:/down/upload/";
	
	// get방식으로 접속시
	@RequestMapping(value="/sortable", method=RequestMethod.GET)
	public String showIndexPage(HttpServletRequest request, HttpServletResponse response) {
		return "sortable/sortable";
	}
	
	// edit 페이지에서 다음 버튼눌렀을떄 유저의 정보를받아와서 저장
	@RequestMapping(value="/sortable", method=RequestMethod.POST)
	public String showSortPage(@RequestParam("m_id") String m_id,
								 @RequestParam("dirNum") int dirNum,
								 @RequestParam("dirName") String dirName,
								 HttpServletRequest request, HttpServletResponse response) throws IOException{
		// json 으로 가져와서 json으로 출력--- 다시 보기 위해 남겨둠 
//		BufferedReader httpBody = request.getReader();
//		StringBuffer sb = new StringBuffer();
//		String line = null;
//		while ((line = httpBody.readLine()) != null) {
//			sb.append(line).append('\n');
//		}
//		String json = sb.toString();
//		System.out.println(json);
		
		file.setM_id(m_id);
		file.setDirNum(dirNum);
		file.setDirName(dirName);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("file", file);
		
		return "sortable/sortable";
	}
	
	// sort 페이지의 썸네일과 각 파일정보를  파일 리스트에 담아서 페이지에 전송
	@RequestMapping(value="/sortThumbLoad", method=RequestMethod.POST)
	public @ResponseBody List<FileVO> sortThumbLoad(@ModelAttribute("file") FileVO file, HttpServletRequest request, HttpServletResponse response) throws Exception {
		file.setDirNum(this.file.getDirNum());
		
		
		List<FileVO> fileList=sortService.fileList(file);
		for(int i=0; i<fileList.size(); i++){
			fileList.get(i).setDirName(this.file.getDirName());
		}
		
		
		return fileList;
		
	}
	
	// sort페이지에서 이미지의 순서를 정하면 DB에 이미지의 순서를 반영하는 부분
	@RequestMapping(value="/sortImgOrder", method=RequestMethod.POST)
	public @ResponseBody int sortImgOrder(@ModelAttribute("file") FileVO file, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = sortService.imgOrderInsert(file);
		
		return result;
	}
	
}
