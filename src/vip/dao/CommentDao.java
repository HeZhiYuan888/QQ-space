package vip.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.resource.po.Comment;
import org.resource.po.Member;
import org.resource.po.Title;
import org.util.HibernateUtil;

public class CommentDao {
	public static void savaComment(Comment ct)
	{
		@SuppressWarnings("static-access")
		Session session=HibernateUtil.currentSession();
		Transaction transaction=session.beginTransaction();
		
	try {
		//	Query query=session.createQuery("");
		session.save(ct);
		transaction.commit();
	} catch (Exception e) {
		// TODO: handle exception
		transaction.rollback();
	}
	finally
	{
		HibernateUtil.closeSession();
	}
	}
	/*
	 * 罗列出所有跟文章有关的评论
	 */
	/*public static List<Comment> listComment(Title title)	
	{
		List<Comment> comments = new ArrayList<Comment>();
		Session session=HibernateUtil.currentSession();
		Transaction transaction=session.beginTransaction();
		int  id=title.getTitle_id();
		String hql="from Comment as co where co.comment_titleId="+id+"";
		System.out.println("生成的hql语句："+hql);
		Query query = session.createQuery(hql);
		comments = query.list();	
		System.out.println("用listComment的得到的comments的尺寸+++++++++++++++++++"+comments.size());
		transaction.commit();
		HibernateUtil.closeSession();
		return comments;
		
	}*/
	
	/*
	 * listComments配合是用的方法，循环找出所有的子评论，并且装进 list中。
	 */
	public static  List forList(Comment comment,List listComments)
	{
		Iterator it=comment.getComments().iterator();
		while(it.hasNext())
		{
			Map map = new HashMap();
			Comment comm=(Comment) it.next();
			map.put("person1", comm.getMember().getName());
			map.put("person2", comment.getMember().getName());
			map.put("content", comm.getComment_content());
			listComments.add(map);
			if(comm.getComments().hashCode()!=0)
			{
				forList(comm,listComments);
			}
		}
		return listComments;
	}
	/*
	 * 列出多对多关系下   带有  回复  的评论，结果装进listcomments中。
	 */
	public static List listComments(Title title)
	{
		Session session=HibernateUtil.currentSession();
	//	Transaction transaction=session.beginTransaction();
		Title tt=(Title) session.load(Title.class, title.getTitle_id());
		Iterator it = tt.getComments().iterator();
		List listComments = new ArrayList();
		while(it.hasNext())
		{
			Map map0=new HashMap();
			Comment comment = (Comment) it.next();
			map0.put("person",comment.getMember().getName());
			map0.put("content", comment.getComment_content());
			listComments.add(map0);
			if(comment.getComments().hashCode()!=0)
			{
				forList(comment,listComments);
			}
					
		}

//		transaction.commit();
		HibernateUtil.closeSession();
		return listComments;
		
	}
	
	public static Title loadTitle(int titleId)
	{
		Session session = HibernateUtil.currentSession();
	//	Transaction transaction = session.beginTransaction();
		Title title = (Title) session.load(Title.class, titleId);
	//	transaction.commit();
		HibernateUtil.closeSession();
		return title;
		
	}

}
