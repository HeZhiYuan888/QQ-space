package base_action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.eclipse.jdt.internal.compiler.util.Sorting;
import org.resource.po.Comment;
			import org.resource.po.Member;
import org.util.HibernateUtil;

import com.opensymphony.xwork2.ActionContext;

import friends_service.FriendService;
import vip.dao.CommentDao;
import vip.dao.TitleDao;
import viq.service.LoginService;


public class LoginAction extends HttpServlet {
	private int account;
	private Member member;
	private Comment comment;
	private int sex;
	
	private String password;
	private List<Member> listMember=null;
	private List listTitle;	
		
	private String name;
	private int vip_id;
	private Set friends;
	private List demolist=new ArrayList();
	public List getDemolist() {
		return demolist;
	}
	public void setDemolist(List demolist) {
		this.demolist = demolist;
	}
	public Set getFriends() {
		return friends;
	}
	public void setFriends(Set friends) {
		this.friends = friends;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}

	public List getListTitle() {
		return listTitle;
	}
	public void setListTitle(List listTitle) {
		this.listTitle = listTitle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	boolean b=false;
	
	public int getVip_id() {
		return vip_id;
	}
	public void setVip_id(int vip_id) {
		this.vip_id = vip_id;
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public List<Member> getListMember() {
		return listMember;
	}
	public void setListMember(List<Member> listMember) {
		this.listMember = listMember;
	}
	
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;		
	}
	
	public String execute()	
	 {		
		System.out.println("我娶过来的账号："+member.getVip_id());
		System.out.println("我娶过来的密码"+member.getPassword());
			boolean b=LoginService.checkLogin(member.getVip_id(),member.getPassword());	
			System.out.println("返回值："+b);		
			if(b)
			{				//demolist例子
				demolist.add("第一行");
				demolist.add("第二行");
				demolist.add("第三行");
				demolist.add("第四行");
				
				listTitle=TitleDao.listTitle(this.getMember());	
				this.setFriends(FriendService.listFriends(this.getMember()));		
				HttpServletRequest request = ServletActionContext.getRequest(); 
				HttpSession session=request.getSession();
				Member mm=new LoginService().selectName(this.getMember());				
				session.setAttribute("vip", mm);
				return "succ";	
			}
			return "err";	
	 }
	
}
