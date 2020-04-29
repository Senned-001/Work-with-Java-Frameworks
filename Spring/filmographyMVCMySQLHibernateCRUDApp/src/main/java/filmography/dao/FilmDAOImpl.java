package filmography.dao;

import filmography.model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDAOImpl implements FilmDAO  {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")                                  //for ignoring List<Film>=List<?>
    public List<Film> allFilms(int page) {      //get all data from table films
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film").setFirstResult(10 * (page - 1)).setMaxResults(10).list(); //take 10 values from table, starts with page
    }

    @Override
    public int filmsCount() {                   //counter for all data in table
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Film", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(Film film) {        //add data to table films
        Session session = sessionFactory.getCurrentSession();
        session.persist(film);
    }

    @Override
    public void delete(Film film) {     //delete data from table films
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    @Override
    public void edit(Film film) {       //edit data in table films
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public Film getById(int id) {       //search by id in table films
        Session session = sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }
}
