package org.util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static org.hibernate.SessionFactory sessionFactory;//线程安全的SessionFactory
	private static Configuration cfg=new Configuration();//线程安全的SessionFactory
	private static String CONFIG_FILE_LOCATION="org/resource/hibernate.cfg.xml";
	static
	{
		try {
			System.out.println("我到这里来了，老贺1");
			cfg = new Configuration().configure(CONFIG_FILE_LOCATION);
			System.out.println("我到这里来了，老贺1.1");
			sessionFactory = cfg.buildSessionFactory();
			System.out.println("我到这里来了，老贺1.2");			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	 public static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	 /**
	     * 获取当前线程中的Session
	     * @return Session
	     * @throws HibernateException
	     */
	    public static Session currentSession() throws HibernateException {
	    	
	        Session s = (Session) session.get();
	        // 如果Session还没有打开，则新开一个Session
	        if (s == null||!s.isOpen()) {
	        	if(sessionFactory==null){
					try{						
						cfg.configure(CONFIG_FILE_LOCATION);
						System.out.println("我到这里来了，老贺2");
						sessionFactory=cfg.buildSessionFactory();
					}catch(Exception e){
						System.err.println("%%%Error Creating SessionFactory%%%");
						e.printStackTrace();
					}
	         
	        }
	        	   s = sessionFactory.openSession();
		            session.set(s);         //将新开的Session保存到线程局部变量中	       
	    }
	        return s;
	    }
	    public static void closeSession() throws HibernateException {
	        //获取线程局部变量，并强制转换为Session类型
	        Session s = (Session) session.get();
	        session.set(null);
	        if (s!= null)
	            s.close();
	        
	        System.out.println("session关闭");
	    }
}
