package pl.sda.persistance;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static final SessionFactory session = buildSessionFactory();

    private static final String USERNAME = "hibernate.connection.username";
    private static final String PASSWORD = "hibernate.connection.password";
    private static final String URL = "hibernate.connection.url";

    private static SessionFactory buildSessionFactory(){
        try {
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .configure("hibernate.cfg.xml")
//                    .build();
//            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//            return metadata.getSessionFactoryBuilder().build();
            return new Configuration()
                    .setProperty(USERNAME,getVariable(USERNAME))
                    .setProperty(PASSWORD,getVariable(PASSWORD))
                    .setProperty(URL,getVariable(URL)+getVariable(USERNAME))
                    .configure()
                    .buildSessionFactory();
        }catch (Throwable e){
            System.err.println("Inintial Session Factory creation failed "+e);
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory(){
        return session;
    }

    public static void shutDown(){
        getSessionFactory().close();
    }

    private static String getVariable(String key){
        return System.getenv(key.replace(".","_"));
    }
}
