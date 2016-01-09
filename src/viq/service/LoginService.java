package viq.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.resource.po.Member;
import org.resource.po.Title;
import org.util.HibernateUtil;

public class LoginService {
	public static boolean checkLogin(int account,String password)
	{
		Session session=null;
		Transaction transaction=null;
		boolean b=false;
		List<Member> list=new ArrayList<Member>();
		Member mm=new Member();
		mm.setVip_id(account);
		session=HibernateUtil.currentSession();
		//transaction=session.beginTransaction();
		System.out.println("输入账号是"+account);		
		System.out.println("输入密码是"+password);		
		String hql="from Member mm where mm.vip_id="+account+"";
		try {
				Query query =session.createQuery(hql);
				list=query.list();
				System.out.println("数据库里的密码是"+list.get(0).getPassword());					
				if(list.get(0).getPassword().equals(password))
				{
					//System.out.println("我进入到判断里了");
					b=true;
					//System.out.println(b);
				}
			}		
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}		
		finally{
			HibernateUtil.closeSession();
		}
		return b;
	}
	/*
	 * 根据传入的成员对象的账号获取该对象
	 */
	public  Member selectName(Member mem)
	{
		Session session=HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		List list=new ArrayList<Member>();
		int id=mem.getVip_id();
		String que="from Member as m where m.vip_id="+id+"";
		System.out.println("获得的sql语句是："+que);
		Query query=session.createQuery(que);
		list=query.list();
		System.out.println("获得的list的尺寸是"+list.size());
		System.out.println("获得的list的尺寸是"+list.get(0));
		Member mm=(Member) list.get(0);		
		return  mm;
	}
	
	// * 将文章对象封装成map
	 
	public Map ObjToMap(Title title)
	{
		Map map=new HashMap();
		map.put("title_content", title.getTitle_content());
		map.put("title_name", title.getTitle_name());
		map.put("title_host", title.getTitle_host());
		map.put("title_id", title.getTitle_id());	
		map.put("title_time", title.getTitle_time());
		map.put("member",title.getMember());
	//	map.put("zan",title.getZan());
		return map;
		
	}
	
	// * 根据文章表中的title——host查询出member表中的name
	 
	public String selectTitleName(Title tt)
	{
		Session session=HibernateUtil.currentSession();
		List list=new ArrayList<Title>();
		int id=tt.getTitle_host();
		String que="from Member as m where m.vip_id="+id+"";
		System.out.println("获得的sql语句是："+que);
		Query query=session.createQuery(que);
		list=query.list();
		System.out.println("获得的list的尺寸是"+list.size());
		System.out.println("获得的list的尺寸是"+list.get(0));
		Member mm=(Member) list.get(0);
		String name=mm.getName();
		return  name;
	}
	
	// * 根据登录者的ID  获取其好友list
	 
	
}
